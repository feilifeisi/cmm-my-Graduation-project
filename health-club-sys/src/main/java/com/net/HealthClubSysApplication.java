package com.net;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.net")
public class HealthClubSysApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthClubSysApplication.class, args);
	}

}
