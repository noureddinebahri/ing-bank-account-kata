package fr.ing.interview.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.ing.interview.message.AccountVO;
import fr.ing.interview.message.DepositMoneyVO;
import fr.ing.interview.message.ResponseMessage;
import fr.ing.interview.message.TransactionVO;
import fr.ing.interview.message.WithdrawMoneyVO;
import fr.ing.interview.service.BankAccountKataManagementService;

@CrossOrigin(origins = "*", maxAge = 3600) //"http://localhost:4200", "http://localhost:8081/bank-account-kata-back-office"
@Controller
@RequestMapping("/bank-account")
public class BankAccountKataController {

	@Autowired
	private BankAccountKataManagementService bankAccountKataManagementService;

	/**
	 * User Story 1 :
	 * As a bank, deposit money from a customer to his account, is allowed when superior to €0.01
	 * 
	 * @return The {HttpStatus.OK} status if the deposit money is successfully done.
	 */
	@PutMapping("/depositMoney")
	public ResponseEntity<ResponseMessage> depositMoney(@RequestParam("depositMoney") DepositMoneyVO depositMoneyVO) {

		final boolean result = bankAccountKataManagementService.depositMoney(depositMoneyVO);

		if (result) {
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Money deposited successfully"));
		}

		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ResponseMessage("Deposit Money unauthorized"));
	}

	/**
	 * User Story 2 :
	 * As a bank, withdraw money from a customer account, is allowed when no overdraft used
	 * 
	 * @return The {HttpStatus.OK} status if the withdraw money is successfully done.
	 */
	@PostMapping("/withdrawMoney")
	public ResponseEntity<ResponseMessage> withdrawMoney(@RequestParam("withdrawMoney") WithdrawMoneyVO withdrawMoneyVO) {

		final boolean result = bankAccountKataManagementService.withdrawMoney(withdrawMoneyVO);

		if (result) {
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Money withdrawed successfully"));
		}

		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ResponseMessage("Withdraw Money unauthorized"));
	}

	/**
	 * User Story 3 :
	 * As a bank, a customer can display its account balance
	 * 
	 * @return AccountVO balance as Double value.
	 */
	@PostMapping("/getAccountBalance")
	public ResponseEntity<TransactionVO> getAccountBalance(@RequestParam("account") AccountVO accountVO) {

		final TransactionVO transactionVO = bankAccountKataManagementService.getAccountBalance(accountVO);

		return ResponseEntity.status(HttpStatus.OK).body(transactionVO);
	}

	/**
	 * User Story 4 :
	 * As a bank, a customer can display its account transactions history
	 * 
	 * @return AccountVO history as List of transaction (Deposit, Withdraw, ...).
	 */
	@PostMapping("/getAccountHistory")
	public ResponseEntity<List<TransactionVO>> getAccountHistory(@RequestParam("account") AccountVO accountVO) {

		final List<TransactionVO> transactionVOList = bankAccountKataManagementService.getAccountHistory(accountVO);

		return ResponseEntity.status(HttpStatus.OK).body(transactionVOList);
	}
}
