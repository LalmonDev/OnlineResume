package com.lalmondev.online_resume.controller;


import com.lalmondev.online_resume.model.Result;
import com.lalmondev.online_resume.model.UserEntity;
import com.lalmondev.online_resume.service.UserService;
import com.lalmondev.online_resume.util.Encryption;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Resource(name = "userServiceImpl")
    private UserService userService;

    private Encryption encryption;


    @CrossOrigin
    @RequestMapping(value = "/api/getUsers",method= RequestMethod.GET)
    @ResponseBody
    public List<UserEntity> getAllUsers(){

        List<UserEntity> userInfoList = new ArrayList<>(100);

        try {
            userInfoList = userService.getAllUsers();
            System.out.println("获取用户列表成功");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("获取用户列表失败");
            return null;
        }

        return userInfoList;
    }


    /**
     * 根据用户名，获取用户信息
     *
     * @param user_name
     * @return
     */
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
     * 根据用户手机，获取用户名
     *
     * @param user_phone
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/api/findUserName",method= RequestMethod.GET)
    @ResponseBody
    public UserEntity getUserNameByPhone(@RequestParam("user_phone") String user_phone){

        System.out.println("获取的手机号：" + user_phone);

        UserEntity userEntity = userService.getUserNameByPhone(user_phone);
        if (userEntity != null){
            System.out.println("获取用户名成功");
            return userEntity;
        }else {
            System.out.println("获取用户名失败");
            return null;
        }
    }


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

        if ((DBuserEntity.getUser_name().equals(userEntity.getUser_name())) && DBuserEntity.getUser_password().equals(encryption.MD5Encryption(userEntity.getUser_password()))){
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
            userEntity.setUser_password(encryption.MD5Encryption(userEntity.getUser_password()));
            userService.insert(userEntity);
            System.out.println("注册成功");
            return new Result(200);
        }else {
            return new Result(400);
        }
    }

    /**
     * 根据用户名，修改用户密码
     *
     * @param user_name
     * @return
     */
    @CrossOrigin
    @PostMapping("api/findPasswd")
    public Result userPasswordUpdate(@RequestBody UserEntity userEntityTemp) {
        String user_password = userEntityTemp.getUser_password();
        String user_name = userEntityTemp.getUser_name();
        System.out.println(user_name + "需要改密码" + user_password);

        UserEntity userEntity = userService.getUserEntityByLoginName(user_name);

        UserEntity newUserEntity = new UserEntity();
        newUserEntity.setUser_name(user_name);
        newUserEntity.setUser_phone(userEntity.getUser_phone());
        newUserEntity.setUser_password(encryption.MD5Encryption(user_password));

        try {
            userService.update(user_name,newUserEntity);
            System.out.println("修改成功");
        }catch (Exception e){
            System.out.println("修改失败");
            return new Result(400);
        }

        return new Result(200);
    }

    /**
     * 通过用户名删除用户
     *
     */
    @CrossOrigin
    @PostMapping("api/delete")
    public Result deleteUserByName(@RequestBody UserEntity userEntity) {

        String userName = userEntity.getUser_name();

        try {
            userService.deleteUserByName(userName);
            System.out.println(userName + "删除成功");
        }catch (Exception e){
            System.out.println(userName + "删除失败");
            return new Result(400);
        }

        return new Result(200);
    }


}
