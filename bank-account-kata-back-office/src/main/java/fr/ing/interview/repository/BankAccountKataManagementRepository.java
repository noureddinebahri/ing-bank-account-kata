package fr.ing.interview.repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.ing.interview.message.AccountVO;
import fr.ing.interview.message.DepositMoneyVO;
import fr.ing.interview.message.WithdrawMoneyVO;
import fr.ing.interview.message.TransactionVO;
import fr.ing.interview.model.AccountDO;
import fr.ing.interview.model.DepositMoneyDO;
import fr.ing.interview.model.TransactionDO;
import fr.ing.interview.model.WithdrawMoneyDO;

@Repository
public class BankAccountKataManagementRepository {

	@Autowired
	private BankAccountKataManagementAccountRepository bankAccountKataManagementAccountRepository;
	@Autowired
	private BankAccountKataManagementTransactionRepository bankAccountKataManagementTransactionRepository;
	@Autowired
	private BankAccountKataManagementDepositMoneyRepository bankAccountKataManagementDepositMoneyRepository;
	@Autowired
	private BankAccountKataManagementWithdrawMoneyRepository bankAccountKataManagementWithdrawMoneyRepository;

	public boolean depositMoney(final DepositMoneyVO depositMoneyVO) {

		final boolean result;
		
		final AccountDO accountDO = bankAccountKataManagementAccountRepository.getOne(depositMoneyVO.getAccount().getId());

		if (null == accountDO) {
			
			result = Boolean.FALSE.booleanValue();

		} else {
			
			final double computedAmount = retrieveComputedAmount(accountDO.getId());
			final Date now = Calendar.getInstance().getTime();
			final TransactionDO transactionDO = buildTransactionDO(accountDO);
			transactionDO.setOperationDate(now);
			transactionDO.setComputedAmount(computedAmount + depositMoneyVO.getAmount());
			
			final TransactionDO transactionDOSaved = bankAccountKataManagementTransactionRepository.save(transactionDO);
			
			final DepositMoneyDO depositMoneyDO = buildDepositMoneyDO(depositMoneyVO, accountDO, transactionDOSaved);
			depositMoneyDO.setOperationDate(now);
			depositMoneyDO.setTransaction(transactionDOSaved);
			
			final DepositMoneyDO depositMoneyDOSaved = bankAccountKataManagementDepositMoneyRepository.save(depositMoneyDO);
			transactionDOSaved.setDepositMoney(depositMoneyDOSaved);
			bankAccountKataManagementTransactionRepository.save(transactionDOSaved);
			
			result = Boolean.TRUE.booleanValue();
		}

		return result;
	}

	@Transactional
	public boolean withdrawMoney(final WithdrawMoneyVO withdrawMoneyVO) {

		final boolean result;
		
		final AccountDO accountDO = bankAccountKataManagementAccountRepository.getOne(withdrawMoneyVO.getAccount().getId());

		if (null == accountDO) {
			
			result = Boolean.FALSE.booleanValue();

		} else {
			
			final double computedAmount = retrieveComputedAmount(accountDO.getId());
			final Date now = Calendar.getInstance().getTime();
			final TransactionDO transactionDO = buildTransactionDO(accountDO);
			transactionDO.setOperationDate(now);
			transactionDO.setComputedAmount(computedAmount - withdrawMoneyVO.getAmount());
			
			final TransactionDO transactionDOSaved = bankAccountKataManagementTransactionRepository.save(transactionDO);
			
			final WithdrawMoneyDO withdrawMoneyDO = buildWithdrawMoneyDO(withdrawMoneyVO, accountDO, transactionDOSaved);
			withdrawMoneyDO.setOperationDate(now);
			withdrawMoneyDO.setTransaction(transactionDOSaved);
			
			final WithdrawMoneyDO withdrawMoneyDOSaved = bankAccountKataManagementWithdrawMoneyRepository.save(withdrawMoneyDO);
			transactionDOSaved.setWithdrawMoney(withdrawMoneyDOSaved);
			bankAccountKataManagementTransactionRepository.save(transactionDOSaved);
			
			result = Boolean.TRUE.booleanValue();
		}

		return result;
	}

	public TransactionVO getAccountBalance(final AccountVO accountVO) {
		
		final TransactionVO transactionVO;

		final AccountDO accountDO = bankAccountKataManagementAccountRepository.getOne(accountVO.getId());

		if (accountDO == null) {
			
			transactionVO = null;

		} else {
			
			final List <TransactionDO> lastTransactionDOList = getLastTransactionDOList(accountVO.getId());
			
			if (lastTransactionDOList.isEmpty()) {
				transactionVO = new TransactionVO(accountVO, /*depositMoney*/null, /*withdrawMoney*/null, /*computedAmount*/(double) 0);
				
			} else {
				
				final TransactionDO transactionDO = lastTransactionDOList.get(0);
				transactionVO = 
						new TransactionVO(
								accountVO, 
								buildDepositMoneyVO(transactionDO.getDepositMoney(), accountDO, transactionDO), 
								buildWithdrawMoneyVO(transactionDO.getWithdrawMoney(), accountDO, transactionDO), 
								transactionDO.getComputedAmount());
			}
		}

		return transactionVO;
	}

	/**
	 * Retrieve last 10 Transactions from DB.
	 * 
	 * @param accountVO The Requested AccountDO related to this operation.
	 * @return List of 10 operations. Empty if no result. Null if impossible to proceed to this request by the given AccountDO.
	 */
	public List<TransactionVO> getAccountHistory(final AccountVO accountVO) {
		
		final List<TransactionVO> transactionVOList;

		final AccountDO accountDO = bankAccountKataManagementAccountRepository.getOne(accountVO.getId());

		if (null == accountDO) {
			
			transactionVOList = null;

		} else {
			
			final List <TransactionDO> last10TransactionDOList = getLast10TransactionDOList(accountVO.getId());
			
			if (last10TransactionDOList.isEmpty()) {
				transactionVOList = new ArrayList<TransactionVO>();
				
			} else {
				
				transactionVOList = new ArrayList<TransactionVO>();
				
				for (final TransactionDO transactionDO : last10TransactionDOList) {
					
					transactionVOList.add( 
							new TransactionVO(
									accountVO, 
									buildDepositMoneyVO(transactionDO.getDepositMoney(), accountDO, transactionDO), 
									buildWithdrawMoneyVO(transactionDO.getWithdrawMoney(), accountDO, transactionDO), 
									transactionDO.getComputedAmount())
							);
				}
			}
		}

		return transactionVOList;
	}
	
	public double retrieveComputedAmount(final long accountId) {
		
		final double computedAmount;
		
		final List <TransactionDO> lastTransactionDOList = getLastTransactionDOList(accountId);
		
		if (lastTransactionDOList.isEmpty()) {
			computedAmount = 0;
		} else {
			computedAmount = lastTransactionDOList.get(0).getComputedAmount();
		}
		
		return computedAmount;
	}
	
	private List<TransactionDO> getLastTransactionDOList(final Long accountId) {
		
		//final Sort sortDescOnOperationDate = Sort.by(Sort.Direction.DESC, "OPERATION_DATE");
		//final Example<TransactionDO> exampleTransaction = Example.of(TransactionDO.from(accoundId));
		//final List<TransactionDO> transactionDOList = bankAccountKataManagementTransactionRepository.findAll(exampleTransaction, sortDescOnOperationDate);
		final AccountDO accountDO = new AccountDO();
		accountDO.setId(accountId);
		final List<TransactionDO> transactionDOList = bankAccountKataManagementTransactionRepository.findTop1ByAccountOrderByOperationDateDesc(/*account.getId()*/accountDO);
		
		return transactionDOList;
	}
	
	private List<TransactionDO> getLast10TransactionDOList(final Long accountId) {
		
		//final Sort sortDescOnOperationDate = Sort.by(Sort.Direction.DESC, "OPERATION_DATE");
		//final Example<TransactionDO> exampleTransaction = Example.of(TransactionDO.from(accoundId));
		//final List<TransactionDO> transactionDOList = bankAccountKataManagementTransactionRepository.findAll(exampleTransaction, sortDescOnOperationDate);
		final AccountDO accountDO = new AccountDO();
		accountDO.setId(accountId);
		final List<TransactionDO> transactionDOList = bankAccountKataManagementTransactionRepository.findTop10ByAccountOrderByOperationDateDesc(/*account.getId()*/accountDO);
		
		return transactionDOList;
	}

	private DepositMoneyDO buildDepositMoneyDO(final DepositMoneyVO depositMoneyDO, final AccountDO accountDO, final TransactionDO transactionDO) {
		
		if (null == depositMoneyDO) {
			return null;
		}

		return new DepositMoneyDO(
				depositMoneyDO.getId(),
				depositMoneyDO.getAmount(), 
				depositMoneyDO.getCurrency(), 
				accountDO, 
				depositMoneyDO.getReference(), 
				depositMoneyDO.getOperationDate(),
				transactionDO);
	}
	
	private DepositMoneyVO buildDepositMoneyVO(final DepositMoneyDO depositMoneyDO, final AccountDO accountDO, final TransactionDO transactionDO) {
		
		if (null == depositMoneyDO) {
			return null;
		}
		
		final AccountVO accountVO = buildAccountVO(accountDO);
		
		return new DepositMoneyVO(
				depositMoneyDO.getId(),
				depositMoneyDO.getAmount(), 
				depositMoneyDO.getCurrency(), 
				accountVO, 
				depositMoneyDO.getReference(), 
				depositMoneyDO.getOperationDate());
	}

	private WithdrawMoneyDO buildWithdrawMoneyDO(final WithdrawMoneyVO withdrawMoneyVO, final AccountDO accountDO, final TransactionDO transactionDO) {
		
		if (null == withdrawMoneyVO) {
			return null;
		}

		return new WithdrawMoneyDO(
				withdrawMoneyVO.getId(),
				withdrawMoneyVO.getAmount(), 
				withdrawMoneyVO.getCurrency(), 
				accountDO, 
				withdrawMoneyVO.getOperationDate(),
				transactionDO);
	}

	private WithdrawMoneyVO buildWithdrawMoneyVO(final WithdrawMoneyDO withdrawMoneyDO, final AccountDO accountDO, final TransactionDO transactionDO) {
		
		if (null == withdrawMoneyDO) {
			return null;
		}
		
		final AccountVO accountVO = buildAccountVO(accountDO);
		
		return new WithdrawMoneyVO(
				withdrawMoneyDO.getId(),
				withdrawMoneyDO.getAmount(), 
				withdrawMoneyDO.getCurrency(), 
				accountVO, 
				withdrawMoneyDO.getOperationDate());
	}

	private TransactionDO buildTransactionDO(final AccountDO accountDO) {

		return new TransactionDO(
				accountDO, 
				/*depositMoneyDO*/null, 
				/*withdrawMoneyDO*/null, 
				/*computedAmount*/null, 
				/*operationDate*/null);
	}

	@SuppressWarnings("unused")
	private AccountDO buildAccountDO(final AccountVO accountVO) {

		return new AccountDO(
				accountVO.getId(),
				accountVO.getCodeBanque(), 
				accountVO.getCodeAgence(), 
				accountVO.getNumeroDeCompte(), 
				accountVO.getCleRib(), 
				accountVO.getAgenceDeDomiciliation(), 
				accountVO.getCurrency());
	}

	private AccountVO buildAccountVO(final AccountDO accountDO) {

		return new AccountVO(
				accountDO.getId(), 
				accountDO.getCodeBanque(), 
				accountDO.getCodeAgence(), 
				accountDO.getNumeroDeCompte(), 
				accountDO.getCleRib(), 
				accountDO.getAgenceDeDomiciliation(), 
				accountDO.getCurrency());
	}
}
