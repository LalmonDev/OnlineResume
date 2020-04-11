package com.lalmondev.online_resume;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.lalmondev.online_resume.dao")
@SpringBootApplication
public class OnlineResumeApplication {

	public static void main(String[] args) {

		SpringApplication.run(OnlineResumeApplication.class, args);
	}

}
