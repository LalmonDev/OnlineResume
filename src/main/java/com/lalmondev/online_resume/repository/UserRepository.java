package com.lalmondev.online_resume.repository;

import com.lalmondev.online_resume.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

//一定要是interface,继承JpaRepository来完成对数据库的操作 <实体类，主键类型>
public interface UserRepository extends JpaRepository<User,Integer> {

}
