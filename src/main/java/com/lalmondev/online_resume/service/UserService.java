package com.lalmondev.online_resume.service;

import com.lalmondev.online_resume.model.UserEntity;

import java.util.List;

public interface UserService {
    public void insert(UserEntity userEntity);
    public void del(UserEntity userEntity);

    /**
     * 通过登录名得到用户信息
     * @param user_name
     * @return
     */
    public UserEntity getUserEntityByLoginName(String user_name);

    /**
     * 获取user列表
     * @param user_name
     * @param pageSize
     * @param page
     * @return
     */
    public List<UserEntity> userList(String user_name, int pageSize, int start);

    /**
     * 获取user列表的总量
     * @param user_name
     * @param pageSize
     * @param page
     * @return
     */
    public Integer usersSize(String user_name, int pageSize, int start);

    /**
     * 新建用户信息
     * @param userEntity
     */
    public void insertUser(UserEntity userEntity);

    /**
     * 更新用户信息
     * @param userEntity
     */
    public void updateUser(UserEntity userEntity);

    /**
     * 删除用户信息
     * @param groupId
     */
    public void deleteUsers(List<String> groupId);

}
