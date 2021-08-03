import { Account } from "./account.model";

export class DepositMoney {
	id: number;
    amount: number;
    currency: string;
    account: Account;
    reference: string;
    operationDate: string;

}
