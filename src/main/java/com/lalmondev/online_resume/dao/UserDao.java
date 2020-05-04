package com.lalmondev.online_resume.dao;


import com.lalmondev.online_resume.model.UserEntity;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface UserDao {
    public ArrayList<UserEntity> select(@Param("userEntity") UserEntity userEntity);

    public void del(@Param("userEntity") UserEntity userEntity);

    public void update(@Param("user_name")String user_name,@Param("userEntity") UserEntity userEntity);

    public void insert(@Param("userEntity") UserEntity userEntity);

    //根据用户名删除用户
    public void deleteUserByName(@Param("user_name")String user_name);

    //根据用户手机号，获取用户名
    public UserEntity getUserNameByPhone(@Param("user_phone")String user_phone);

    //根据用户名获取手机号
    public UserEntity getPhoneByUserName(@Param("user_name")String user_name);


    /**
     * 通过登录名获取用户信息
     */
    public UserEntity getUserEntityByLoginName(@Param("user_name") String user_name);

    /**
     * 获取user列表
     * @param user_name
     * @param null
     * @return
     */
    public ArrayList<UserEntity> getAllUsers();


    /**
     * 获取user列表
     * @param user_name
     * @param null
     * @param
     * @return
     */
    public ArrayList<UserEntity> usersList(@Param("user_name")String user_name,@Param("pageSize") int pageSize,@Param("start") int start);

    /**
     * 获取user列表的总量
	 * @param user_name
	 * @param pageSize
	 * @param page
	 * @return
     */
    public Integer usersSize(@Param("user_name")String user_name,@Param("pageSize") int pageSize,@Param("start") int start);

    /**
     * 新建用户信息
     * @param userEntity
     */
    public void insertUser(@Param("userEntity") UserEntity userEntity);

    /**
     * 更新用户信息
     * @param userEntity
     */
    public void updateUser(@Param("userEntity") UserEntity userEntity);

    /**
     * 删除用户信息
     * @param groupId
     */
    public void deleteUsers(@Param("groupId") List<String> groupId);
}
