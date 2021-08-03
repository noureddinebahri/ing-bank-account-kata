import { Account } from "./account.model";

export class WithdrawMoney {
	id: number;
    amount: number;
    currency: string;
    account: Account;
    operationDate: string;

}
