package com.lalmondev.online_resume.service.impl;

import com.lalmondev.online_resume.dao.URDao;
import com.lalmondev.online_resume.model.UREntity;
import com.lalmondev.online_resume.service.URService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "URServiceImpl")
public class URServiceImpl implements URService {

    @Autowired
    private URDao urDao;

    @Override
    public void insertUREntity(UREntity urEntity) {
        urDao.insertUREntity(urEntity);
    }

    @Override
    public void updateUREntity(int resume_id,UREntity urEntity) {
        urDao.updateUREntity(resume_id,urEntity);
    }

    @Override
    public void deleteUREntity(int resumeid) {
        urDao.deleteUREntity(resumeid);
    }

    @Override
    public UREntity getResumeIdByUserName(String username) {
        return urDao.getResumeIdByUserName(username);
    }
}
