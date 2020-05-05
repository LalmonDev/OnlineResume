package com.lalmondev.online_resume.service.impl;

import com.lalmondev.online_resume.dao.ResumeDao;
import com.lalmondev.online_resume.model.ResumeEntity;
import com.lalmondev.online_resume.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "resumeServiceImpl")
public class ResumeServiceImpl implements ResumeService {

    @Autowired
    private ResumeDao resumeDao;

    @Override
    public void insert(ResumeEntity resumeEntity){
        resumeDao.insert(resumeEntity);
    }

    @Override
    public void update(int resume_id,ResumeEntity resumeEntity){
        resumeDao.update(resume_id,resumeEntity);
    }

    @Override
    public ResumeEntity getResumeEntityById(int resume_id) {
        return resumeDao.getResumeEntityById(resume_id);
    }

    @Override
    public ResumeEntity getResumeIdByName(String name) {
       return resumeDao.getResumeIdByName(name);
    }
}
