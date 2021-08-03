package fr.ing.interview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.ing.interview.model.AccountDO;

@Repository
public interface BankAccountKataManagementAccountRepository extends JpaRepository<AccountDO, Long> {

}
