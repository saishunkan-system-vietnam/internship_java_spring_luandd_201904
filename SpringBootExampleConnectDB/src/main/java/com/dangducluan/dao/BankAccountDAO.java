package com.dangducluan.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.dangducluan.entities.*;
import com.dangducluan.exception.BankTransactionException;
import com.dangducluan.mapper.BankAccountMapper;

@Repository
//@Transactional
public class BankAccountDAO extends JdbcDaoSupport{
	@Autowired
	public BankAccountDAO(DataSource dataSource)
	{
		this.setDataSource(dataSource);
	}
	public List<BankAccountInfo> getListAccoutInfo()
	{
		String sql = BankAccountMapper.QUERY_SQL;
		Object[] params = new Object[] {};
		BankAccountMapper bankAccountMapper = new BankAccountMapper();
		List<BankAccountInfo> list = this.getJdbcTemplate().query(sql,params, bankAccountMapper);
		return list;
	}
	
	public BankAccountInfo findBankAccountInfo(Long id)
	{
		String sql = BankAccountMapper.QUERY_SQL + " where id = ?";
		Object[] params = new Object[] {id};
		BankAccountMapper bankAccountMapper = new BankAccountMapper();
		try {
			BankAccountInfo bankAccountInfo = this.getJdbcTemplate().queryForObject(sql, params, bankAccountMapper);
			return bankAccountInfo;
		}catch(Exception ex) {
			
		}
		return null;
		
	}
	@Transactional(propagation = Propagation.MANDATORY)
	public void addMount(Long id, double amount) throws BankTransactionException
	{
		BankAccountInfo bankAccountInfo = findBankAccountInfo(id);
		if(bankAccountInfo == null) {
			throw new BankTransactionException("Account not found "+id);
		}
		double newBalance = bankAccountInfo.getBalance() + amount;
		if(newBalance < 0) {
			throw new BankTransactionException("The money in the account "+id+" is not enough ("+bankAccountInfo.getBalance()+")");
		}
		bankAccountInfo.setBalance(newBalance);
		String sql = "update bank_account set balance = ? where id = ?";
		this.getJdbcTemplate().update(sql,bankAccountInfo.getBalance(),id);
	}
	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = BankTransactionException.class)
	public void sendMoney(Long fromAccountId, Long toAccountId, double amount) throws BankTransactionException
	{
		addMount(fromAccountId, amount);
		addMount(toAccountId, -amount);
	}
	
}
