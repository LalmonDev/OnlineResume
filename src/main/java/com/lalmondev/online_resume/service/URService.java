package com.lalmondev.online_resume.service;

import com.lalmondev.online_resume.model.UREntity;

public interface URService {

    public void insertUREntity(UREntity urEntity);

    public UREntity getResumeIdByUserName(String username);

}
