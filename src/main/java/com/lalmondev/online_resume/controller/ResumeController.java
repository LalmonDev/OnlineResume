package com.lalmondev.online_resume.controller;

import com.lalmondev.online_resume.model.Result;
import com.lalmondev.online_resume.model.ResumeEntity;
import com.lalmondev.online_resume.model.UREntity;
import com.lalmondev.online_resume.service.ResumeService;
import com.lalmondev.online_resume.service.URService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class ResumeController {

    @Resource(name = "resumeServiceImpl")
    private ResumeService resumeService;

    @Resource(name = "URServiceImpl")
    private URService urService;

    /**
     * 新建简历
     * 先查询数据库 ur_info，是否存在对应用户名下的简历id
     * 1、如果存在，则执行更新简历数据库的操作；
     * 2、不存在，则执行插入简历数据库操作，并插入 ur_info,记录。
     * @param user_name
     * @param resumeEntity
     * @return
     */
    @CrossOrigin
    @PostMapping("api/newResume/{user_name}")
    public Result newResume(@PathVariable String user_name,@RequestBody ResumeEntity resumeEntity){

        UREntity urEntity = new UREntity();
        int resumeId ;

        System.out.println("请求insert的信息：" + resumeEntity.toString());

        if (urService.getResumeIdByUserName(user_name) != null)
        {
            System.out.println(user_name + "存在简历信息");

            resumeId = urService.getResumeIdByUserName(user_name).getResumeid();
            resumeService.update(resumeId,resumeEntity);

            System.out.println(user_name + "更新成功");
        } else {
            System.out.println(user_name + "不存在简历信息");

            resumeService.insert(resumeEntity);
            resumeId = resumeService.getResumeIdByName(resumeEntity.getName()).getResume_id();
            urEntity.setUsername(user_name);
            urEntity.setResumeid(resumeId);
            urService.insertUREntity(urEntity);

            System.out.println(user_name + "插入成功");
        }

        return new Result(200);
    }

}
