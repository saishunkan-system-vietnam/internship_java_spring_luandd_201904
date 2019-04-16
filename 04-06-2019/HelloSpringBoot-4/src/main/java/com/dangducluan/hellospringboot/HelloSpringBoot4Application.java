package com.dangducluan.hellospringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ComponentScan(basePackages = "com.dangducluan.controller")
public class HelloSpringBoot4Application {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringBoot4Application.class, args);
	}

}
