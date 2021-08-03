package fr.ing.interview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.ing.interview.model.DepositMoneyDO;

@Repository
public interface BankAccountKataManagementDepositMoneyRepository extends JpaRepository<DepositMoneyDO, Long> {
	
}
