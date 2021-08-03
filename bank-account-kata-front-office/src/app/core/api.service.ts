import { Injectable, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Account } from "../model/account.model";
import { DepositMoney } from "../model/depositMoney.model";
import { ResponseMessage } from "../model/responseMessage.model";
import { Transaction } from "../model/transaction.model";
import { User } from "../model/user.model";
import { WithdrawMoney } from "../model/withdrawMoney.model";

import { BehaviorSubject } from 'rxjs';
import { Observable } from "rxjs/index";
import { ApiResponse } from "../model/api.response";

@Injectable()
export class ApiService implements OnInit {

  private usersBaseUrl: string = 'http://localhost:8081/bank-account-kata-front-office/users/';
  private bankAccountKataBaseUrl: string = 'http://localhost:8081/bank-account-kata-front-office/bank-account/';

  private loggedIn: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);

  constructor(private http: HttpClient) {
  }

  ngOnInit() {    
  }

  /* --------------------------------------------------------------- */
  /* ------------- Authentication Guard Service -------------------- */
  /* --------------------------------------------------------------- */
  login(loginPayload): Observable<ApiResponse> {
    return this.http.post<ApiResponse>('http://localhost:8081/bank-account-kata-front-office/' + 'token/generate-token', loginPayload);
  }
  regeneratePassword(forgotPasswordPayload): Observable<ApiResponse> {
    return this.http.post<ApiResponse>('http://localhost:8081/bank-account-kata-front-office/' + 'token/regeneratePassword', forgotPasswordPayload);
  }
  sendUsername(forgotUsernamePayload): Observable<ApiResponse> {
    return this.http.post<ApiResponse>('http://localhost:8081/bank-account-kata-front-office/' + 'token/sendUsername', forgotUsernamePayload);
  }

  /* --------------------------------------------------------------- */
  /* -------------------- Users Service ---------------------------- */
  /* --------------------------------------------------------------- */
  getUsers(): Observable<ApiResponse> {
    return this.http.get<ApiResponse>(this.usersBaseUrl);
  }
  getUserById(id: number): Observable<ApiResponse> {
    return this.http.get<ApiResponse>(this.usersBaseUrl + id);
  }
  createUser(user: User): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.usersBaseUrl + 'saveUser', user);
  }
  updateUser(user: User): Observable<ApiResponse> {
    return this.http.put<ApiResponse>(this.usersBaseUrl, user);
  }
  deleteUser(id: number): Observable<ApiResponse> {
    return this.http.delete<ApiResponse>(this.usersBaseUrl + id);
  }

  /* --------------------------------------------------------------- */
  /* ---------------- Authentication Service ----------------------- */
  /* --------------------------------------------------------------- */
  get token() {
    return window.localStorage.getItem('token');
  }
  get username() {
    return window.localStorage.getItem('username');
  }
  get isLoggedIn() {

    const tokenFromLocalStorage = this.token;

    if ((typeof (tokenFromLocalStorage) == "undefined" || tokenFromLocalStorage == null || tokenFromLocalStorage == '')) {
      this.loggedIn = new BehaviorSubject<boolean>(false);
    } else {
      this.loggedIn = new BehaviorSubject<boolean>(true);
    }

    return this.loggedIn.asObservable();
  }

  loginEvent(token: string, username: string) {

    window.localStorage.setItem('token', token);
    window.localStorage.setItem('username', username);

    this.loggedIn.next(true);
  }

  logoutEvent() {

    // Remove token and all relative informations from local storage to log user out
    window.localStorage.removeItem('token');
    window.localStorage.removeItem('username');

    this.loggedIn.next(false);
  }

  /* --------------------------------------------------------------- */
  /* -------------------- Bank Account Kata Service ---------------- */
  /* --------------------------------------------------------------- */
  depositMoney(depositMoney: DepositMoney): Observable<ApiResponse> {

    return this.http.put<ApiResponse>(this.bankAccountKataBaseUrl + 'depositMoney', depositMoney);
  }
  withdrawMoney(withdrawMoney: WithdrawMoney): Observable<ApiResponse> {

      return this.http.post<ApiResponse>(this.bankAccountKataBaseUrl + 'withdrawMoney', withdrawMoney);
    }
  getAccountBalance(account: Account): Observable<ApiResponse> {

      return this.http.post<ApiResponse>(this.bankAccountKataBaseUrl + 'getAccountBalance', account);
    }
  getAccountHistory(account: Account): Observable<ApiResponse> {

      return this.http.post<ApiResponse>(this.bankAccountKataBaseUrl + 'getAccountHistory', account);
    }
}
