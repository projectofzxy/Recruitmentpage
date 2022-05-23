package service;

import dao.RecruitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.*;

import java.util.List;
@Service
public class RecruitServiceImpl implements RecruitService{

    @Autowired
    private RecruitMapper recruitMapper;

    public void setRecruitMapper(RecruitMapper recruitMapper) {
        this.recruitMapper = recruitMapper;
    }

    @Override
    public int addUser(User user) {
        return recruitMapper.addUser(user);
    }

    @Override
    public int addAnnouncement(Announcement announcement) {
        return recruitMapper.addAnnouncement(announcement);
    }

    @Override
    public int addApplyuser(Applyuser applyuser) {
        return recruitMapper.addApplyuser(applyuser);
    }

    @Override
    public int addDeliveryInformation(DeliveryInformation deliveryInformation) {
        return recruitMapper.addDeliveryInformation(deliveryInformation);
    }

    @Override
    public int addRecruiter(Recruiter recruiter) {
        return recruitMapper.addRecruiter(recruiter);
    }

    @Override
    public int addRecruitmentInformation(RecruitmentInformation recruitmentInformation) {
        return recruitMapper.addRecruitmentInformation(recruitmentInformation);
    }

    @Override
    public List<Announcement> queryAllAnnouncement() {
        return recruitMapper.queryAllAnnouncement();
    }

    @Override
    public List<RecruitmentInformation> queryAllRecruitmentInformation() {
        return recruitMapper.queryAllRecruitmentInformation();
    }

    @Override
    public List<DeliveryInformation> queryAllDeliveryInformation(String companyname) {
        return recruitMapper.queryAllDeliveryInformation(companyname);
    }

    @Override
    public List<Recruiter> queryAllRecruiter() {
        return recruitMapper.queryAllRecruiter();
    }

    @Override
    public Recruiter queryRecruiterById(int id) {
        return recruitMapper.queryRecruiterById(id);
    }

    @Override
    public User queryUser(String username) {
        return recruitMapper.queryUser(username);
    }

    @Override
    public Applyuser queryApplyuser(String username) {
        return recruitMapper.queryApplyuser(username);
    }

    @Override
    public DeliveryInformation queryDeliveryInformationById(int id) {
        return recruitMapper.queryDeliveryInformationById(id);
    }

    @Override
    public int deleteAnnouncement(int id) {
        return recruitMapper.deleteAnnouncement(id);
    }

    @Override
    public int deleteDeliveryInformation(int id) {
        return recruitMapper.deleteDeliveryInformation(id);
    }

    @Override
    public int deleteRecruiter(int id) {
        return recruitMapper.deleteRecruiter(id);
    }

    @Override
    public int updateUser(User user) {
        return recruitMapper.updateUser(user);
    }

    @Override
    public int updateApplyuser(Applyuser applyuser) {
        return recruitMapper.updateApplyuser(applyuser);
    }

    @Override
    public int updateRecruitmentInformation(RecruitmentInformation recruitmentInformation) {
        return recruitMapper.updateRecruitmentInformation(recruitmentInformation);
    }
}
