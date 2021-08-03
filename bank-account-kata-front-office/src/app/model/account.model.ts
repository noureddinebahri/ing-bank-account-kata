export class Account {
    id: number;
    codeBanque: string;
    codeAgence: string;
    numeroDeCompte: string;    
    cleRib: string;
    agenceDeDomiciliation: string;
    currency: string;
}

export class AccountCriteria {
    id: number;
    codeBanque: string;
    codeAgence: string;
    numeroDeCompte: string;    
    cleRib: string;
    agenceDeDomiciliation: string;
    currency: string;
}

export class AccountPagination {
	firstResult: number;
	maxResults: number;
}

export class AccountRequest {
	uploadedFileCriteria: AccountCriteria;
	pagination: AccountPagination;
}
