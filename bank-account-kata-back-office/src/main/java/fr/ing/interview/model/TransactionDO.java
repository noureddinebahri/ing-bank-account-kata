package fr.ing.interview.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TRANSACTION")
public class TransactionDO {

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue
	private long id;

	@OneToOne
	private AccountDO account;

	@OneToOne
	private DepositMoneyDO depositMoney;

	@OneToOne
	private WithdrawMoneyDO withdrawMoney;

	@Column(name = "COMPUTED_AMOUNT")
	private Double computedAmount;

	@Column(name = "OPERATION_DATE")
	private Date operationDate;

	public TransactionDO() {
	}

	public TransactionDO(final AccountDO account, final DepositMoneyDO depositMoney, final WithdrawMoneyDO withdrawMoney, final Double computedAmount, final Date operationDate) {
		this.account = account;
		this.depositMoney = depositMoney;
		this.withdrawMoney = withdrawMoney;
		this.computedAmount = computedAmount;
		this.operationDate = operationDate;
	}

	public static TransactionDO from(final Long accountId) {
		
		final AccountDO account = new AccountDO();
		account.setId(accountId);
		
		return new TransactionDO(account, /*depositMoney*/null, /*withdrawMoney*/null, /*computedAmount*/null, /*operationDate*/null);
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
	public void setAccount(AccountDO account) {
		this.account = account;
	}

	/**
	 * @return the depositMoney
	 */
	public DepositMoneyDO getDepositMoney() {
		return depositMoney;
	}

	/**
	 * @param depositMoney the depositMoney to set
	 */
	public void setDepositMoney(DepositMoneyDO depositMoney) {
		this.depositMoney = depositMoney;
	}

	/**
	 * @return the withdrawMoney
	 */
	public WithdrawMoneyDO getWithdrawMoney() {
		return withdrawMoney;
	}

	/**
	 * @param withdrawMoney the withdrawMoney to set
	 */
	public void setWithdrawMoney(WithdrawMoneyDO withdrawMoney) {
		this.withdrawMoney = withdrawMoney;
	}

	/**
	 * @return the computedAmount
	 */
	public double getComputedAmount() {
		return computedAmount;
	}

	/**
	 * @param computedAmount the computedAmount to set
	 */
	public void setComputedAmount(double computedAmount) {
		this.computedAmount = computedAmount;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
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
	public void setOperationDate(Date operationDate) {
		this.operationDate = operationDate;
	}
}
