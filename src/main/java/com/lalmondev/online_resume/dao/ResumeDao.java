package com.lalmondev.online_resume.dao;

import com.lalmondev.online_resume.model.ResumeEntity;
import org.apache.ibatis.annotations.Param;

public interface ResumeDao {

    public void insert(@Param("resumeEntity") ResumeEntity resumeEntity);

    public void update(@Param("resume_id")int resume_id ,@Param("resumeEntity") ResumeEntity resumeEntity);

    public ResumeEntity getResumeEntityById(@Param("resume_id") int resume_id);

    public ResumeEntity getResumeIdByName(@Param("name") String name);
}
