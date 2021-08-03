package fr.ing.interview.message;

public class TransactionVO {

	private long id;

	private AccountVO account;

	private DepositMoneyVO depositMoney;

	private WithdrawMoneyVO withdrawMoney;

	private double computedAmount;

	public TransactionVO() {
	}

	public TransactionVO(final AccountVO account, final DepositMoneyVO depositMoney, final WithdrawMoneyVO withdrawMoney,
			final double computedAmount) {
		this.account = account;
		this.depositMoney = depositMoney;
		this.withdrawMoney = withdrawMoney;
		this.computedAmount = computedAmount;
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
	public void setAccount(AccountVO account) {
		this.account = account;
	}

	/**
	 * @return the depositMoney
	 */
	public DepositMoneyVO getDepositMoney() {
		return depositMoney;
	}

	/**
	 * @param depositMoney the depositMoney to set
	 */
	public void setDepositMoney(DepositMoneyVO depositMoney) {
		this.depositMoney = depositMoney;
	}

	/**
	 * @return the withdrawMoney
	 */
	public WithdrawMoneyVO getWithdrawMoney() {
		return withdrawMoney;
	}

	/**
	 * @param withdrawMoney the withdrawMoney to set
	 */
	public void setWithdrawMoney(WithdrawMoneyVO withdrawMoney) {
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
}
