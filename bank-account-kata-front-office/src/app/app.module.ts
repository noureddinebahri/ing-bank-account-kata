import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';

import { HTTP_INTERCEPTORS, HttpClientModule } from "@angular/common/http";
import { TokenInterceptor } from "./core/interceptor";
import { ErrorInterceptor } from './_helpers';

import { ReactiveFormsModule } from "@angular/forms";
import { routing } from "./app.routing";

import { LoginComponent } from './login/login.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { HomeComponent } from './home/home.component';

import { DepositMoneyComponent } from './depositMoney/depositMoney.component';

import { ApiService } from "./core/api.service";
import { AuthenticationGuardService } from './auth/authentication-guard.service';
 
import { NgxPaginationModule } from 'ngx-pagination';
import { ForgotUsernameComponent } from './forgot-username/forgot-username.component';


@NgModule({
  declarations: [
    AppComponent,  
      
    LoginComponent,
    HomeComponent,    
    
    DepositMoneyComponent,
    
    ForgotPasswordComponent,
    ForgotUsernameComponent
  ],
  imports: [
    BrowserModule,
    routing,
    ReactiveFormsModule,
    HttpClientModule,
    NgxPaginationModule
  ],
  providers: [
    ApiService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptor,
      multi: true
    },
    AuthenticationGuardService,
    { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})

export class AppModule { }
