package service;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import pojo.*;

import java.util.List;
@Service
public interface RecruitService {
    int addUser(User user);//添加用户
    int addAnnouncement(Announcement announcement);//添加公告
    int addApplyuser(Applyuser applyuser);//添加简介信息
    int addDeliveryInformation(DeliveryInformation deliveryInformation);//添加投递信息
    int addRecruiter(Recruiter recruiter);//应聘者请求信息
    int addRecruitmentInformation(RecruitmentInformation recruitmentInformation);//添加招聘信息
    List<Announcement> queryAllAnnouncement();//查询所有公告
    List<RecruitmentInformation> queryAllRecruitmentInformation();//查询所有招聘信息
    List<DeliveryInformation> queryAllDeliveryInformation(String companyname);//查询投递该公司的简历
    List<Recruiter> queryAllRecruiter();//查询所有申请公司
    Recruiter queryRecruiterById(int id);//
    User queryUser(String username);//查询用户是否存在
    Applyuser queryApplyuser(String username);
    DeliveryInformation queryDeliveryInformationById(int id);
    int deleteAnnouncement(int id);//删除公告
    int deleteDeliveryInformation(int id);//删除投递信息
    int deleteRecruiter(int id);//删除应聘者请求信息
    int updateUser(User user);//更新用户信息
    int updateApplyuser(Applyuser applyuser);//更新简介
    int updateRecruitmentInformation(RecruitmentInformation recruitmentInformation);//更新招聘信息
}
