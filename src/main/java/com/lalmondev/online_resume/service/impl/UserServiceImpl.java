package com.lalmondev.online_resume.service.impl;


import com.lalmondev.online_resume.dao.UserDao;
import com.lalmondev.online_resume.model.UserEntity;
import com.lalmondev.online_resume.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "userServiceImpl")
public class UserServiceImpl  implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public void insert(UserEntity userEntity){
        userDao.insert(userEntity);
    }

    @Override
    public void del(UserEntity userEntity) {
        userDao.del(userEntity);
    }

    @Override
    public void update(String user_name,UserEntity userEntity) {
        userDao.update(user_name,userEntity);
    }

    @Override
    public UserEntity getUserEntityByLoginName(String user_name) {
        return userDao.getUserEntityByLoginName(user_name);
    }

    @Override
    public UserEntity getUserNameByPhone(String user_phone) {
        return userDao.getUserNameByPhone(user_phone);
    }

    @Override
    public UserEntity getPhoneByUserName(String user_name) {
        return userDao.getPhoneByUserName(user_name);
    }

    @Override
    public List<UserEntity> userList(String user_name, int pageSize, int start) {
        return userDao.usersList(user_name,pageSize,start);
    }

    @Override
    public Integer usersSize(String user_name, int pageSize, int start) {
        return userDao.usersSize(user_name,pageSize,start);
    }

    @Override
    public void insertUser(UserEntity userEntity) {
        userDao.insertUser(userEntity);
    }

    @Override
    public void updateUser(UserEntity userEntity) {
        userDao.updateUser(userEntity);
    }

    @Override
    public void deleteUsers(List<String> groupId) {
        userDao.deleteUsers(groupId);
    }


}
