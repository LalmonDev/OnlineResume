package com.lalmondev.online_resume.controller;

import com.lalmondev.online_resume.entity.resultCode;
import com.lalmondev.online_resume.entity.vueUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class loginController {


    @CrossOrigin     //跨域
    @PostMapping(value = "api/login")
    @ResponseBody
    public resultCode login(@RequestBody vueUser requestUser){
        String username = requestUser.getUsername();
        String password = requestUser.getPassword();
//        username = HtmlUtils.htmlEscape(username);
        System.out.println("请求信息:" + username + "  " + password);
        if (username.equals("luo") && password.equals("luo")){
            System.out.println("登陆成功");
            return new resultCode(200);
        }else {
            System.out.println("用户名或者密码错误");
            return new resultCode(400);
        }
    }
}
