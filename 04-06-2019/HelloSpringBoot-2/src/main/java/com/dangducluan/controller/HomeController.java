package com.dangducluan.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dangducluan.entities.Person;

@Controller
@RequestMapping(path = "/")
public class HomeController {
	
	private static List<Person> persons = new ArrayList<Person>();
	
	static {
		persons.add(new Person("Dang","Luan"));
		persons.add(new Person("Hoang","Nam"));
	}
	
	@Value("${welcome.message}")
	private String message;
	
	@Value("${error.message}")
	private String errorMessage;
	
	@GetMapping
	public String Default(ModelMap modelMap)
	{
		modelMap.addAttribute("message",message);
		return "index";
	}
	@GetMapping(path = "/listperson")
	public String listPerson(ModelMap modelMap)
	{
		modelMap.addAttribute("persons", persons);
		return "listperson";
	}
	@GetMapping(path = "/addperson")
	public String addPerson(ModelMap modelMap)
	{
		Person person = new Person();
		modelMap.addAttribute("person", person);
		return "addperson";
	}
}
