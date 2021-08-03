package fr.ing.interview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.ing.interview.model.WithdrawMoneyDO;

@Repository
public interface BankAccountKataManagementWithdrawMoneyRepository extends JpaRepository<WithdrawMoneyDO, Long> {
	
}
