package com.dangducluan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dangducluan.dao.BankAccountDAO;
import com.dangducluan.daoimp.BankAccountImp;
import com.dangducluan.entities.BankAccount;
@Service
public class BankAccountService implements BankAccountImp{

	@Autowired
	BankAccountDAO bankAccountDAO;
	@Override
	public List<BankAccount> getListBankAccount() {
		// TODO Auto-generated method stub
		return bankAccountDAO.getListBankAccount();
	}
	@Override
	public void sendMoneyToAccount(Long fromAccount, Long toAccount, double amount) {
		// TODO Auto-generated method stub
		bankAccountDAO.sendMoneyToAccount(fromAccount, toAccount, amount);
	}

}
