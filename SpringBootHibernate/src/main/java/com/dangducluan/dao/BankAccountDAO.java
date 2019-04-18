package com.dangducluan.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dangducluan.daoimp.BankAccountImp;
import com.dangducluan.entities.BankAccount;
import com.dangducluan.exception.BankAccountException;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class BankAccountDAO implements BankAccountImp{

	@Autowired
	SessionFactory sessionFactory;
	@Transactional
	@Override
	public List<BankAccount> getListBankAccount() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<BankAccount> listBankAccount = session.createQuery("from bank_account").getResultList();
		return listBankAccount;
	}
	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = BankAccountException.class)
	@Override
	public void sendMoneyToAccount(Long fromAccount, Long toAccount, double amount) {
		// TODO Auto-generated method stub
		addAmountMoney(fromAccount, amount);
		addAmountMoney(toAccount, -amount);
	}
	@Transactional
	private void addAmountMoney(Long id, double amount)
	{
		Session session = sessionFactory.getCurrentSession();
		BankAccount bankAccount = session.get(BankAccount.class, id);
	}

}
