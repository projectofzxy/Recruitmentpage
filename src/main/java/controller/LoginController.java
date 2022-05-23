package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.Recruiter;
import pojo.User;
import service.RecruitService;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    @Qualifier("RecruitServiceImpl")
    private RecruitService recruitService;
    private int i = 0;

    @RequestMapping("/begin")
    public String login(){
        return "login";
    }

    @RequestMapping("/creat")
    public String creat(){
        return "creat";
    }

    @RequestMapping("/pwdfindback")
    public String pwdfindback(){
        return "pwdfindback";
    }


    @RequestMapping("/dologin")
    public String dologin(String username,String password,Model model,HttpSession session){
        User user = recruitService.queryUser(username);
        if (user==null){
            model.addAttribute("error","用户名不存在");
            return "login";
        }else if (!user.getPassword().equals(password)){
            model.addAttribute("error","密码错误");
            return "login";
        }
        else if (user.getAuthority()==4){
            model.addAttribute("username",username);
            session.setAttribute("username",username);
            return "redirect:/main/main4";
        }
        else if (user.getAuthority()==3){
            model.addAttribute("username",username);
            session.setAttribute("username",username);
            return "redirect:/main/main3";
        }
        else if (user.getAuthority()==2){
            model.addAttribute("username",username);
            session.setAttribute("username",username);
            return "redirect:/main/main2";
        }

        return "login";
    }
    @RequestMapping("/pwdfind")
    public String pwdfind(String username,String mail,String mail_password, HttpServletRequest request,Model model)throws IOException {
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        User user = recruitService.queryUser(username);


        if (action.equals("发送验证码")){
        if (user==null){
            model.addAttribute("information","用户名错误！");
            return "pwdfindback";
        }else if (!user.getMail().equals(mail)){
            model.addAttribute("information","邮箱错误！");
            return "pwdfindback";
        }else {
            try {
                String from = "1007977461@qq.com";
                String password="ixfoxadrbfrxbejj";
                Random random=new Random();
                i = random.nextInt(1000000);
                //生成 SMTP 的主机名称
                int n = from.indexOf('@');
                int m = from.length();
                String mailserver = "smtp." + from.substring(n + 1, m);
                //建立邮件会话
                Properties pro = new Properties();
                pro.put("mail.smtp.host", mailserver);
                pro.put("mail.smtp.auth", "true");
                Session sess = Session.getInstance(pro);
                sess.setDebug(true);
                //新建一个消息对象
                MimeMessage message = new MimeMessage(sess);
                //设置发件人
                InternetAddress from_mail = new InternetAddress(from);
                message.setFrom(from_mail);
                //设置收件人
                InternetAddress to_mail = new InternetAddress(mail);
                message.setRecipient(Message.RecipientType.TO, to_mail);
                //设置主题
                message.setSubject("邮箱验证码");
                //设置内容
                BodyPart body = new MimeBodyPart();
                body.setText(String.valueOf(i));
                Multipart multipart = new MimeMultipart();
                multipart.addBodyPart(body);
                message.setContent(multipart);
                //设置发送时间
                message.setSentDate(new Date());
                //发送邮件
                message.saveChanges(); //保证报头域同会话内容保持一致
                Transport transport = sess.getTransport("smtp");
                transport.connect(mailserver, from, password);
                transport.sendMessage(message, message.getAllRecipients());
                transport.close();

                model.addAttribute("information","发送成功");
                return "pwdfindback";
            }catch (Exception e){
                model.addAttribute("information","邮件发送失败！");
            }
        }
        }else if (action.equals("找回密码")){
            if (mail_password.equals(String.valueOf(i))){
                String password = user.getPassword();
                model.addAttribute("information","验证成功！密码为"+password);
            }else {
                model.addAttribute("information","验证失败！");
            }
            return "pwdfindback";
        }
        return "pwdfindback";
    }
    @RequestMapping("/addUser")
    public String addUser(String username,String password,String password1,String mail,String name,String birthday,String gender,Model model){
        if (!password.equals(password1)){
            model.addAttribute("summary","密码不一致");
        }
        if (recruitService.queryUser(username)!=null){
            model.addAttribute("summary","用户名已存在");
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
        user.setAuthority(2);
        recruitService.addUser(user);
        model.addAttribute("summary","注册成功！");
        return "creat";
    }
    @RequestMapping("/tobezhaoping")
    public String tobezhaoping(){
        return "bezpf";
    }
    @RequestMapping("/bezhaoping")
    public String bezhaoping(Model model, Recruiter recruiter){
        String username = recruiter.getUsername();
        User user = recruitService.queryUser(username);
        if (user!=null){
            model.addAttribute("error","账号已存在");
            return "bezpf";
        }
        recruitService.addRecruiter(recruiter);
        model.addAttribute("error","申请成功，请等待邮件通知");
        return "bezpf";
    }
}
