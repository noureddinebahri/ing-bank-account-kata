package fr.ing.interview.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.ing.interview.model.AccountDO;
import fr.ing.interview.model.TransactionDO;

@Repository
public interface BankAccountKataManagementTransactionRepository extends JpaRepository<TransactionDO, Long> {
	
	//List<TransactionDO> findTop1ByAccountOrderByOperationDateDesc(@Param("account.id") Long accountId);
	List<TransactionDO> findTop1ByAccountOrderByOperationDateDesc(AccountDO accountDO);
	
	//List<TransactionDO> findTop10ByAccountOrderByOperationDateDesc(@Param("account.id") Long accountId);
	List<TransactionDO> findTop10ByAccountOrderByOperationDateDesc(AccountDO accountDO);
}
