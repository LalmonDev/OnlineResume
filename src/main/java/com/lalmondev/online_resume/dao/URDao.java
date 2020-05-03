package com.lalmondev.online_resume.dao;

import com.lalmondev.online_resume.model.UREntity;
import org.apache.ibatis.annotations.Param;

public interface URDao {

    public void insertUREntity(@Param("urEntity")UREntity urEntity);

    public UREntity getResumeIdByUserName(@Param("username")String username);

}
