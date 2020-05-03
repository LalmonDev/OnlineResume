package com.lalmondev.online_resume.service;

import com.lalmondev.online_resume.model.ResumeEntity;

public interface ResumeService {
    public void insert(ResumeEntity resumeEntity);

    public void update(int resume_id,ResumeEntity resumeEntity);

    public void getResumeEntityById(int resume_id);

    public ResumeEntity getResumeIdByName(String name);
}
