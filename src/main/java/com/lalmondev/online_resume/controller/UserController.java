package com.lalmondev.online_resume.controller;


import com.lalmondev.online_resume.model.Result;
import com.lalmondev.online_resume.model.UserEntity;
import com.lalmondev.online_resume.service.UserService;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class UserController {
    @Resource(name = "userServiceImpl")
    private UserService userService;

    @CrossOrigin
    @RequestMapping(value = "/api/UserInfo",method= RequestMethod.GET)
    @ResponseBody
    public UserEntity userGet(@RequestParam("user_name") String user_name){
        UserEntity userEntity = userService.getUserEntityByLoginName(user_name);
        if (userEntity != null){
            System.out.println("获取个人信息成功");
            return userEntity;
        }else {
            System.out.println("获取个人信息失败");
            return null;
        }
    }

    /**
     *新建用户
     * @param userEntity
     */
//    @PostMapping("/users/user")
//    public UserEntity insertUser(@RequestBody UserEntity userEntity){
//        userService.insert(userEntity);
//        System.out.println("新建成员：" + userEntity.getUser_name() + " " + userEntity.getUser_password() + " " + userEntity.getUser_phone() );
//
//        if (userEntity != null){
//            System.out.println("插入成功");
//            return userEntity;
//        }else {
//            System.out.println("插入失败");
//            return null;
//        }
//    }

//    登录
    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public Result register(@RequestBody UserEntity userEntity) {
        System.out.println("登录数据：" + userEntity.getUser_name() + " " + userEntity.getUser_password() );
        UserEntity DBuserEntity = userService.getUserEntityByLoginName(userEntity.getUser_name());

        if (DBuserEntity == null){
            System.out.println("登录失败");
            return new Result(400);
        }

        if ((DBuserEntity.getUser_name().equals(userEntity.getUser_name())) && DBuserEntity.getUser_password().equals(userEntity.getUser_password())){
            System.out.println("登录成功");
            return new Result(200);
        }else {
            System.out.println("登录失败");
            return new Result(400);
        }
    }

//    新建用户
    @CrossOrigin
    @PostMapping(value = "api/register")
    @ResponseBody
    public Result login(@RequestBody UserEntity userEntity) {
        System.out.println("新建成员：" + userEntity.getUser_name() + " " + userEntity.getUser_password() + " " + userEntity.getUser_phone() );
        if ((userEntity.getUser_name() != null) && (userEntity.getUser_password() != null) && (userEntity.getUser_phone()!= null)){
            if (userService.getUserEntityByLoginName(userEntity.getUser_name()) != null){
                System.out.println("用户已存在");
                return new Result(201);
            }
            userService.insert(userEntity);
            System.out.println("注册成功");
            return new Result(200);
        }else {
            return new Result(400);
        }
    }



}
