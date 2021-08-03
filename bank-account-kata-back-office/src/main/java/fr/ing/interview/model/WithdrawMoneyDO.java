package fr.ing.interview.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "WITHDRAW_MONEY")
public class WithdrawMoneyDO {

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue
	private long id;

	@Column(name = "AMOUNT")
	private double amount;

	@Column(name = "currency")
	private String currency;

	@OneToOne
	private AccountDO account;

	@Column(name = "OPERATION_DATE")
	private Date operationDate;

	@OneToOne
	private TransactionDO transaction;

	public WithdrawMoneyDO() {
	}

	public WithdrawMoneyDO(final long id, final double amount, final String currency, final AccountDO account, final Date operationDate, final TransactionDO transaction) {
		this.id = id;
		this.amount = amount;
		this.currency = currency;
		this.account = account;
		this.operationDate = operationDate;
		this.transaction = transaction;
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
	public AccountDO getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(final AccountDO account) {
		this.account = account;
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

	/**
	 * @return the transaction
	 */
	public TransactionDO getTransaction() {
		return transaction;
	}

	/**
	 * @param transaction the transaction to set
	 */
	public void setTransaction(TransactionDO transaction) {
		this.transaction = transaction;
	}
}
