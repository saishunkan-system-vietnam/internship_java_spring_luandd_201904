package com.dangducluan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dangducluan.entities.BankAccount;
import com.dangducluan.service.BankAccountService;
import com.dangducluan.formdata.*;

@Controller
@RequestMapping(path = "/")
public class HomeController {
	@Autowired
	BankAccountService bankAccountService;
	@GetMapping
	public String Default(ModelMap modelMap)
	{
		List<BankAccount> listBankAccount = bankAccountService.getListBankAccount();
		modelMap.addAttribute("listAccount", listBankAccount);
		return "index";
	}
	@GetMapping("sendMoney")
	public String showSendMoneyPage(ModelMap modelMap)
	{
		SendMoney sendMoney = new SendMoney(1, 2, 700d);
		modelMap.addAttribute("dataSendMoney", sendMoney);
		return "sendmoney";
	}
	@PostMapping("sendMoney")
	public String sendMoneyToAccount(SendMoney dataSendMoney)
	{
		Long fromAccount = (long) dataSendMoney.getFormAccount();
		Long toAccount = (long) dataSendMoney.getToAccount();
		double amount = dataSendMoney.getAmount();
		bankAccountService.sendMoneyToAccount(fromAccount,toAccount,amount);
		return "redirect:/";
	}
}
