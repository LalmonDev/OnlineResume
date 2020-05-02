package com.lalmondev.online_resume.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.lalmondev.online_resume.model.Result;
import com.lalmondev.online_resume.model.ResumeEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ResumeController {

    @CrossOrigin
    @PostMapping("api/newResume/{user_name}")
    public Result newResume(@PathVariable String user_name,@RequestBody ResumeEntity resumeEntity){

        System.out.println(user_name);
        System.out.println("获取的信息：" + resumeEntity.toString());

        return new Result(200);
    }

}
