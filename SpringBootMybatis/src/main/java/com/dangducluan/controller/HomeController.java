package com.dangducluan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dangducluan.entities.Student;
import com.dangducluan.service.StudentService;

@Controller
@RequestMapping(path = "/")
public class HomeController {
	@Autowired
	StudentService studentService;
	
	@GetMapping
	public String Default(ModelMap modelMap)
	{
		List<Student> students = studentService.getAllListStudent();
		modelMap.addAttribute("students", students);
		return "index";
	}
}
