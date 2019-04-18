package com.dangducluan.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dangducluan.daoimp.BankAccountImp;
import com.dangducluan.entities.BankAccount;
import com.dangducluan.model.BankAccountInfo;

@Repository
public class BankAccountDAO implements BankAccountImp{

	@Autowired
	EntityManager entityManager;
	
	@Override
	public List<BankAccountInfo> listBankAccount() {
		// TODO Auto-generated method stub
        String sql = "select new " + BankAccountInfo.class.getName() //
                + "(e.id,e.fullName,e.balance) " //
                + " from " + BankAccount.class.getName() + " e ";
        System.out.println(sql);
        Query query = entityManager.createQuery(sql, BankAccountInfo.class);
        return query.getResultList();
	}

}
