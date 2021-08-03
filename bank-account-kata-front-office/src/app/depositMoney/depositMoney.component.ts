import { Component, OnInit } from '@angular/core';

import { FormBuilder, FormGroup, Validators, RequiredValidator } from "@angular/forms";
import { HttpClient } from '@angular/common/http';

import { Router } from "@angular/router";
import { ApiService } from "../core/api.service";
import { DepositMoney } from "../model/depositMoney.model";
import { Account } from "../model/account.model";

@Component({
    selector: 'app-depositMoney',
    templateUrl: './depositMoney.component.html',
    styleUrls: ['./depositMoney.component.css']
})
export class DepositMoneyComponent implements OnInit {
    
    constructor(private formBuilder: FormBuilder, private httpClient: HttpClient, private router: Router, private apiService: ApiService) { }
    
    addForm: FormGroup;
    
    ngOnInit() {
        this.addForm = this.formBuilder.group({
            id: [''],
            amount: [''],
            currency: [''],
            reference: [''],
            operationDate: [''],
            codeBanque: [''],
            codeAgence: [''],
            numeroDeCompte: ['']
        });
    }
    
    onFileSelect(event, uploadedFileName) {
        if (event.target.files.length > 0) {
            const file = event.target.files[0];
            this.addForm.get(uploadedFileName).setValue(file);
        }
    }    
    
    onSubmit() {
        
        if (this.addForm.invalid) {
            return;
        }
        
        const depositMoney = new DepositMoney();
        depositMoney.amount = this.addForm.get('amount').value;
        depositMoney.currency = this.addForm.get('currency').value;
        depositMoney.reference = this.addForm.get('reference').value;

        const account = new Account();
        account.codeBanque = this.addForm.get('codeBanque').value;
        account.codeAgence = this.addForm.get('codeAgence').value;
        account.numeroDeCompte = this.addForm.get('numeroDeCompte').value;

        depositMoney.account = account;
        
        this.apiService.depositMoney(depositMoney)
        .subscribe( data => {
            
            if (data.status === 200) {
                
                alert("Deposit Money executed successfuly.");
                this.router.navigate(['/']);
                
            } else {
                alert(data.message);
                console.error(data.message);
            }
            
        });
    }
    
    cancel():void{
        this.router.navigate(['/']); 
    }
}

