import { Component, OnInit } from '@angular/core';
import { User } from './model/user.model';
import { Observable, of } from 'rxjs';
import { delay, share } from 'rxjs/operators';
import { ApiService } from './core/api.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  title = 'Bank Account Kata - Front Office';

  public username$: Observable<string>;
  public isLoggedIn$: Observable<boolean>;

  public user: Observable<{}>;

  constructor(private apiService: ApiService) {
  }

  ngOnInit() {    

    this.isLoggedIn$ = this.apiService.isLoggedIn;
    //this.isLoggedIn$.subscribe(isLoggedIn => console.log('isLoggedIn = ' + isLoggedIn));

    this.user = this.getAsyncData().pipe(share());
  }

  getAsyncData() {

    return of({
      username: this.apiService.username
    }).pipe(
      delay(500)
    );
  }

  logout() {
    this.apiService.logoutEvent();
  }
}
