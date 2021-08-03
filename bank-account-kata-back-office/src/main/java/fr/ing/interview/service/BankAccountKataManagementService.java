package fr.ing.interview.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ing.interview.enumeration.Currency;
import fr.ing.interview.message.AccountVO;
import fr.ing.interview.message.DepositMoneyVO;
import fr.ing.interview.message.WithdrawMoneyVO;
import fr.ing.interview.message.TransactionVO;
import fr.ing.interview.repository.BankAccountKataManagementRepository;

@Service
public class BankAccountKataManagementService {

	@Autowired
	private BankAccountKataManagementRepository bankAccountKataManagementRepository;

	@Transactional
	public boolean depositMoney(final DepositMoneyVO depositMoneyVO) {

		final boolean result;
		
		if (	// Règle de Gestion 'Métier' à vérifier avant l'exécution du service.
				depositMoneyVO.getAmount() >= 0.01
				&& 
				Currency.EUR.equals(depositMoneyVO.getCurrency())
			) {
			
			result = bankAccountKataManagementRepository.depositMoney(depositMoneyVO);
			
		} else {
			result = Boolean.FALSE.booleanValue();
		}

		return result;
	}

	@Transactional
	public boolean withdrawMoney(final WithdrawMoneyVO withdrawMoneyVO) {
		
		final boolean result;
		
		final double computedAmount = bankAccountKataManagementRepository.retrieveComputedAmount(withdrawMoneyVO.getAccount().getId());

		if (	// Règle de Gestion 'Métier' à vérifier avant l'exécution du service.
				withdrawMoneyVO.getAmount() <= computedAmount
				&& 
				Currency.EUR.equals(withdrawMoneyVO.getCurrency())
			) {
			
			result = bankAccountKataManagementRepository.withdrawMoney(withdrawMoneyVO);
			
		} else {
			result = Boolean.FALSE.booleanValue();
		}

		return result;
	}

	public TransactionVO getAccountBalance(final AccountVO accountVO) {

		final TransactionVO transactionVO = bankAccountKataManagementRepository.getAccountBalance(accountVO);

		return transactionVO;
	}

	public List<TransactionVO> getAccountHistory(final AccountVO accountVO) {

		final List<TransactionVO> transactionVOList = bankAccountKataManagementRepository.getAccountHistory(accountVO);

		return transactionVOList;
	}
}
