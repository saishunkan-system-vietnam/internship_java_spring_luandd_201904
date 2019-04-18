package com.dangducluan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dangducluan.dao.BankAccountDAO;
import com.dangducluan.daoimp.BankAccountImp;
import com.dangducluan.model.BankAccountInfo;

@Service
public class BankAccountService implements BankAccountImp{

	@Autowired
	BankAccountDAO bankAccountDAO;
	
	@Override
	public List<BankAccountInfo> listBankAccount() {
		// TODO Auto-generated method stub
		return bankAccountDAO.listBankAccount();
	}

}
