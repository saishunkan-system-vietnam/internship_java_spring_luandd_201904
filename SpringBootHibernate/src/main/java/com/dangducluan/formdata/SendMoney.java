package com.dangducluan.formdata;

public class SendMoney {
	private int formAccount;
	private int toAccount;
	private double amount;
	public SendMoney(int formAccount, int toAccount, double amount) {
		super();
		this.formAccount = formAccount;
		this.toAccount = toAccount;
		this.amount = amount;
	}
	public int getFormAccount() {
		return formAccount;
	}
	public void setFormAccount(int formAccount) {
		this.formAccount = formAccount;
	}
	public int getToAccount() {
		return toAccount;
	}
	public void setToAccount(int toAccount) {
		this.toAccount = toAccount;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	
}
