package com.lalmondev.online_resume.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.lalmondev.online_resume.model.Result;
import org.springframework.web.bind.annotation.*;

@RestController
public class ResumeController {

    @CrossOrigin
    @PostMapping(value = "/api/newResume")
    @ResponseBody
    public Result newResume(@RequestBody String user_name, @RequestBody JSONPObject jsonpObject){
        return new Result(200);
    }

}
