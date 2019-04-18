package com.dangducluan.model;

public class BankAccountInfo {
	private Long id;
	private String fullName;
	private String balance;
	
	public BankAccountInfo(Long id, String fullName, String balance) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.balance = balance;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	
}
