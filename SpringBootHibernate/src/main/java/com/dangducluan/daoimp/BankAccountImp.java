package com.dangducluan.daoimp;

import java.util.List;

import com.dangducluan.entities.BankAccount;

public interface BankAccountImp {
	public abstract List<BankAccount> getListBankAccount();
	public abstract void sendMoneyToAccount(Long fromAccount,Long toAccount, double amount);
}
