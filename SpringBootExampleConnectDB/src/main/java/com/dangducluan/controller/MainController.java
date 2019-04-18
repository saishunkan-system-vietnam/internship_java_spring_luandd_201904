package com.dangducluan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dangducluan.dao.BankAccountDAO;
import com.dangducluan.entities.BankAccountInfo;
import com.dangducluan.exception.BankTransactionException;
import com.dangducluan.form.SendMoneyForm;

@Controller
@RequestMapping(path = "/")
public class MainController {
	@Autowired
	private BankAccountDAO bankAccountDAO;
	
	@GetMapping
	public String showBankAccount(ModelMap modelMap)
	{
		List<BankAccountInfo> listBankAccountInfo = bankAccountDAO.getListAccoutInfo();
		modelMap.addAttribute("lisAccount", listBankAccountInfo);
		return "accountPage";
	}
	@GetMapping(path = "sendmoney")
	public String viewSendMoneyPage(ModelMap modelMap) {
		SendMoneyForm sendMoneyForm = new SendMoneyForm(1L, 2L, 700d);
		modelMap.addAttribute("sendMoneyForm", sendMoneyForm);
		return "sendMoneyPage";
	}
	@PostMapping(path = "sendmoney")
	public String processSendMoney(ModelMap modelMap, SendMoneyForm sendMoneyForm)
	{
		try {
			bankAccountDAO.sendMoney(sendMoneyForm.getFromAccoutId(), sendMoneyForm.getToAccountId(), sendMoneyForm.getAmount());
		} catch (BankTransactionException e) {
			// TODO Auto-generated catch block
			modelMap.addAttribute("errorMessage","Error: "+e.getMessage());
			return "redirect:/sendmoney";
		}
		return "redirect:/";
	}
}
