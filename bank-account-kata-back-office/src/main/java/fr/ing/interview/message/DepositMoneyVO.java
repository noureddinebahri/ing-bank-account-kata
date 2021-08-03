package fr.ing.interview.message;

import java.util.Date;

public class DepositMoneyVO {

	private long id;

	private double amount;

	private String currency;

	private AccountVO account;

	private String reference;

	private Date operationDate;

	public DepositMoneyVO() {
	}

	public DepositMoneyVO(final long id, final double amount, final String currency, final AccountVO account, final String reference, final Date operationDate) {
		this.id = id;
		this.amount = amount;
		this.currency = currency;
		this.account = account;
		this.reference = reference;
		this.operationDate = operationDate;
	}

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(final double amount) {
		this.amount = amount;
	}

	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(final String currency) {
		this.currency = currency;
	}

	/**
	 * @return the account
	 */
	public AccountVO getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(final AccountVO account) {
		this.account = account;
	}

	/**
	 * @return the reference
	 */
	public String getReference() {
		return reference;
	}

	/**
	 * @param reference the reference to set
	 */
	public void setReference(final String reference) {
		this.reference = reference;
	}

	/**
	 * @return the operationDate
	 */
	public Date getOperationDate() {
		return operationDate;
	}

	/**
	 * @param operationDate the operationDate to set
	 */
	public void setOperationDate(final Date operationDate) {
		this.operationDate = operationDate;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
}
