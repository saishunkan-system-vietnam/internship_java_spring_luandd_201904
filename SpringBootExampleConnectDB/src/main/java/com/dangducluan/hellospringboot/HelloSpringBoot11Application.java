package com.dangducluan.hellospringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.dangducluan.controller","com.dangducluan.dao"})
public class HelloSpringBoot11Application {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringBoot11Application.class, args);
	}

}
