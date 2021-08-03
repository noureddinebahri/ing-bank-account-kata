import { Account } from "./account.model";
import { DepositMoney } from "./depositMoney.model";
import { WithdrawMoney } from "./withdrawMoney.model";

export class Transaction {
	id: number;
    account: Account;
    depositMoney: DepositMoney;
    withdrawMoney: WithdrawMoney;
    computedAmount: number;

}
