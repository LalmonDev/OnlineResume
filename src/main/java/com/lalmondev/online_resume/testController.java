package com.lalmondev.online_resume;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {
    @RequestMapping("/hello")
    public String hello(){
        return "你好，世界!";
    }
}
