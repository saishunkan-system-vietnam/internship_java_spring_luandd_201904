package com.dangducluan.form;

public class SendMoneyForm {
	private Long fromAccoutId;
	private Long toAccountId;
	private double amount;
	
	public SendMoneyForm(Long fromAccoutId, Long toAccountId, double amount) {
		super();
		this.fromAccoutId = fromAccoutId;
		this.toAccountId = toAccountId;
		this.amount = amount;
	}

	public Long getFromAccoutId() {
		return fromAccoutId;
	}

	public void setFromAccoutId(Long fromAccoutId) {
		this.fromAccoutId = fromAccoutId;
	}

	public Long getToAccountId() {
		return toAccountId;
	}

	public void setToAccountId(Long toAccountId) {
		this.toAccountId = toAccountId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
