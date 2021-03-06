package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import pojo.*;
import service.RecruitService;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

@Controller
@RequestMapping("/main")
public class RecruitController {
    @Autowired
    @Qualifier("RecruitServiceImpl")
    private RecruitService recruitService;
    @RequestMapping("/toperson")
    public String toperson(String username, Model model){
        User user = recruitService.queryUser(username);
        model.addAttribute("user",user);
        return "person";
    }
    @RequestMapping("/tochangeUser")
    public String change(Model model,String username,String mail,String name,String birthday,String gender){
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        if (!birthday.equals("")){
        try {

            date = ft.parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }}
        User user = recruitService.queryUser(username);
        user.setMail(mail);
        user.setName(name);
        user.setBirthday(date);
        user.setGender(gender);
        recruitService.updateUser(user);
        model.addAttribute("information","????????????");
        return "person";
    }
    @RequestMapping("/creatgly")
    public String creatfly(){
        return "creatgly";
    }
    @RequestMapping("/addgly")
    public String addgly(String username,String password,String password1,String mail,String name,String birthday,String gender,Model model){
        if (!password.equals(password1)){
            model.addAttribute("summary","???????????????");
        }
        if (recruitService.queryUser(username)!=null){
            model.addAttribute("summary","??????????????????");
            return "creat";
        }
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {

            date = ft.parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setMail(mail);
        user.setName(name);
        user.setBirthday(date);
        user.setGender(gender);
        user.setAuthority(4);
        recruitService.addUser(user);
        model.addAttribute("summary","???????????????");
        return "creatgly";
    }
    @RequestMapping("/allannouncement")
    public String announcelist(Model model,String username){
        List<Announcement> announcement=recruitService.queryAllAnnouncement();
        model.addAttribute("announcements",announcement);
        User user = recruitService.queryUser(username);
        if (user==null){
            return "redirect:/main/main";
        }
        int authority = user.getAuthority();
        if (authority ==4){
        return "redirect:/main/main4";}
        else if (authority==3){
            return "redirect:/main/main3";
        }else if (authority==2){
        return "redirect:/main/main2";}
        return "redirect:/main/main";
    }
    @RequestMapping("/delannouncement/{Id}")
    public String delannouncement(@PathVariable("Id") int id){
        recruitService.deleteAnnouncement(id);
        return "redirect:/main/main4";
    }
    @RequestMapping("/glyannouncement")
    public String glyannouncement(String announcement){
        if (announcement.equals("")){
            return "redirect:/main/main4";
        }
        Announcement announcement1=new Announcement();
        Date date=new Date();
        announcement1.setAnnouncement(announcement);
        announcement1.setPublisher("?????????");
        announcement1.setDate(date);
        recruitService.addAnnouncement(announcement1);
        return "redirect:/main/main4";

    }
    @RequestMapping("/allrecuritinformation")
    public String allrecuritinformation(Model model){
        List<Recruiter> recruiters = recruitService.queryAllRecruiter();
        model.addAttribute("recruiters",recruiters);
        return "redirect:/main/main4";
    }

    @RequestMapping("/delrecurit/{Id}")
    public String delrecurit(@PathVariable("Id") int id){
        recruitService.deleteRecruiter(id);
        return "redirect:/main/main4";
    }
    @RequestMapping("/passrecurit")
    public String passrecurit(int id){
        Recruiter recruiter = recruitService.queryRecruiterById(id);
        User user=new User();
        user.setMail(recruiter.getMail());
        String username = recruiter.getUsername();
        while (recruitService.queryUser(username)!=null){
            username=username+1;
        }
        user.setUsername(username);
        user.setPassword(recruiter.getPassword());
        user.setAuthority(3);
        recruitService.addUser(user);
        recruitService.deleteRecruiter(id);
        try {
            String from = "1007977461@qq.com";
            String password="ixfoxadrbfrxbejj";
            //?????? SMTP ???????????????
            int n = from.indexOf('@');
            int m = from.length();
            String mailserver = "smtp." + from.substring(n + 1, m);
            //??????????????????
            Properties pro = new Properties();
            pro.put("mail.smtp.host", mailserver);
            pro.put("mail.smtp.auth", "true");
            Session sess = Session.getInstance(pro);
            sess.setDebug(true);
            //????????????????????????
            MimeMessage message = new MimeMessage(sess);
            //???????????????
            InternetAddress from_mail = new InternetAddress(from);
            message.setFrom(from_mail);
            //???????????????
            InternetAddress to_mail = new InternetAddress(recruiter.getMail());
            message.setRecipient(Message.RecipientType.TO, to_mail);
            //????????????
            message.setSubject("????????????");
            //????????????
            BodyPart body = new MimeBodyPart();
            body.setText("????????????"+username+",????????????"+recruiter.getPassword());
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(body);
            message.setContent(multipart);
            //??????????????????
            message.setSentDate(new Date());
            //????????????
            message.saveChanges(); //??????????????????????????????????????????
            Transport transport = sess.getTransport("smtp");
            transport.connect(mailserver, from, password);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();


            return "redirect:/main/main4";
        }catch (Exception ignored){

        }

        return "redirect:/main/main4";
    }
    @RequestMapping("/gsyannouncement")
    public String gsyannouncement(String announcement,String company){
        if (announcement.equals("")|company.equals("")){
            return "redirect:/main/main3";
        }
        Announcement announcement1=new Announcement();
        Date date=new Date();
        announcement1.setAnnouncement(announcement);
        announcement1.setPublisher(company);
        announcement1.setDate(date);
        recruitService.addAnnouncement(announcement1);
        return "redirect:/main/main3";
    }
    @RequestMapping("dorecruitment")
    public String dorecruitment(String username,String recruitment){
        RecruitmentInformation recruitmentInformation=new RecruitmentInformation();
        recruitmentInformation.setHiresname(username);
        recruitmentInformation.setRecruitment(recruitment);
        Date date = new Date();
        recruitmentInformation.setTime(date);
        recruitService.addRecruitmentInformation(recruitmentInformation);
        return "redirect:/main/main3";
    }
    @RequestMapping("/fleshrecruter")
    public String fleshrecruter(String username,Model model){
        List<RecruitmentInformation> recruitmentInformations = recruitService.queryAllRecruitmentInformation();
        model.addAttribute("recruitmentInformations",recruitmentInformations);
        User user = recruitService.queryUser(username);
        if (user==null){
            return "redirect:/main/main";
        }
        int authority = user.getAuthority();
        if (authority ==4){
            return "redirect:/main/main4";}
        else if (authority==3){
            return "redirect:/main/main3";
        }else if (authority==2){
            return "redirect:/main/main2";}
        return "redirect:/main/main";

    }
    @RequestMapping("/submitresume")
    public String submitresume(String username,String companyname,Model model){
        if (username.equals("")){
            return "login";
        }
        Applyuser applyuser = recruitService.queryApplyuser(username);
        String resume = applyuser.getResume();
        DeliveryInformation deliveryInformation=new DeliveryInformation();
        deliveryInformation.setCompanyname(companyname);
        deliveryInformation.setHirername(username);
        deliveryInformation.setResume(resume);
        deliveryInformation.setDate(new Date());
        recruitService.addDeliveryInformation(deliveryInformation);
        model.addAttribute("error","????????????");
        return "redirect:/main/main2";
    }
    @RequestMapping("/saveresume")
    public String saveresume(@RequestParam("resume") CommonsMultipartFile resume , HttpServletRequest request, String username,Model model) throws IOException {
        String filename = resume.getOriginalFilename();
        //?????????????????????????????????????????????
        if ("".equals(filename)){
            model.addAttribute("error","??????????????????");
            return "redirect:/main/main2";
        }
        //????????????????????????
        String path = request.getServletContext().getRealPath("/upload");
        File realPath = new File(path);
        if (!realPath.exists()){
            realPath.mkdir();
        }

        //??????????????????
        System.out.println("???????????????????????????"+realPath);
        resume.transferTo(new File(realPath +"/"+ resume.getOriginalFilename()));
        Applyuser applyuser=new Applyuser();
        applyuser.setUsername(username);
        applyuser.setResume(filename);
        if (recruitService.queryApplyuser(username)!=null){
            recruitService.updateApplyuser(applyuser);
            model.addAttribute("error","??????????????????");
        }else {
        recruitService.addApplyuser(applyuser);
        model.addAttribute("error","??????????????????");
        }
        return "redirect:/main/main2";
    }
    @RequestMapping("/alldeliveryinformation")
    public String alldeliveryinformation(Model model,String username){
        List<DeliveryInformation> deliveryInformations = recruitService.queryAllDeliveryInformation(username);
        model.addAttribute("deliveryInformations",deliveryInformations);
        model.addAttribute("username",username);
        return "redirect:/main/main3";
    }
    @RequestMapping("/deldeliveryinformation")
    public String deldeliveryinformation(int id){
        recruitService.deleteDeliveryInformation(id);
        return "redirect:/main/main3";
    }
    @RequestMapping("/dowload")
    public String dowload(HttpServletResponse response , HttpServletRequest request, int id) throws Exception {
        DeliveryInformation deliveryInformation = recruitService.queryDeliveryInformationById(id);
        String resume = deliveryInformation.getResume();
        String  path = request.getServletContext().getRealPath("/upload");
        //1?????????response ?????????
        response.reset(); //?????????????????????,??????buffer
        response.setCharacterEncoding("UTF-8"); //????????????
        response.setContentType("multipart/form-data"); //?????????????????????
        //???????????????
        response.setHeader("Content-Disposition",
                "attachment;fileName="+ URLEncoder.encode(resume, "UTF-8"));

        File file = new File(path,resume);
        //2??? ????????????--?????????
        InputStream input=new FileInputStream(file);
        //3??? ????????????--?????????
        OutputStream out = response.getOutputStream();

        byte[] buff =new byte[1024];
        int index=0;
        //4????????? ????????????
        while((index= input.read(buff))!= -1){
            out.write(buff, 0, index);
            out.flush();
        }
        out.close();
        input.close();

        return null;
    }
    @RequestMapping("/main4")
    public String showall4(Model model){
        List<Recruiter> recruiters = recruitService.queryAllRecruiter();
        model.addAttribute("recruiters",recruiters);
        List<Announcement> announcement=recruitService.queryAllAnnouncement();
        model.addAttribute("announcements",announcement);
        List<RecruitmentInformation> recruitmentInformations = recruitService.queryAllRecruitmentInformation();
        model.addAttribute("recruitmentInformations",recruitmentInformations);
        return "main4";
    }
    @RequestMapping("/main3")
    public String showall3(Model model,String username){
        List<Announcement> announcement=recruitService.queryAllAnnouncement();
        model.addAttribute("announcements",announcement);
        List<RecruitmentInformation> recruitmentInformations = recruitService.queryAllRecruitmentInformation();
        model.addAttribute("recruitmentInformations",recruitmentInformations);
        List<DeliveryInformation> deliveryInformations = recruitService.queryAllDeliveryInformation(username);
        model.addAttribute("deliveryInformations",deliveryInformations);
        return "main3";
    }
    @RequestMapping("/main2")
    public String showall2(Model model,String error){
        List<Announcement> announcement=recruitService.queryAllAnnouncement();
        model.addAttribute("announcements",announcement);
        List<RecruitmentInformation> recruitmentInformations = recruitService.queryAllRecruitmentInformation();
        model.addAttribute("recruitmentInformations",recruitmentInformations);
        model.addAttribute("error",error);
        return "main2";
    }
    @RequestMapping("/main")
    public String showall(Model model){
        List<Announcement> announcement=recruitService.queryAllAnnouncement();
        model.addAttribute("announcements",announcement);
        List<RecruitmentInformation> recruitmentInformations = recruitService.queryAllRecruitmentInformation();
        model.addAttribute("recruitmentInformations",recruitmentInformations);
        return "main";
    }
}
