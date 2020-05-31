package com.lalmondev.online_resume.service;

import com.lalmondev.online_resume.model.UREntity;

public interface URService {

    public void insertUREntity(UREntity urEntity);
    public void updateUREntity(int resumeid,UREntity urEntity);
    public void deleteUREntity(int resumeid);
    public UREntity getResumeIdByUserName(String username);

}
