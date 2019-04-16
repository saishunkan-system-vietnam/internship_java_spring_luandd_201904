package com.dangducluan.hellospringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.dangducluan.controller"})
public class HelloSpringBoot2Application {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringBoot2Application.class, args);
	}

}
