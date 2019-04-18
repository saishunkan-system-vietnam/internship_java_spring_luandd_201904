package com.dangducluan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dangducluan.service.DepartmentSerivce;

@Controller
@RequestMapping("/")
public class HomeController {
	@Autowired
	DepartmentSerivce departmentSerivce;
	@GetMapping
	public String Default()
	{
		departmentSerivce.displayListDepartmentSearching("Accounting");
		return "index";
	}
}
