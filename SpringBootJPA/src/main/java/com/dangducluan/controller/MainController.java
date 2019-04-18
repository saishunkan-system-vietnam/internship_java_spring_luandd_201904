package com.dangducluan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dangducluan.model.BankAccountInfo;
import com.dangducluan.service.BankAccountService;

@Controller
@RequestMapping
public class MainController {
	@Autowired
	BankAccountService bankAccountService;
	@GetMapping("/")
	public String Default()
	{
		List<BankAccountInfo> listBankAccount = bankAccountService.listBankAccount();
		for(BankAccountInfo ba : listBankAccount) {
			System.out.println(ba.getFullName());
		}
		return "index";
	}
}
