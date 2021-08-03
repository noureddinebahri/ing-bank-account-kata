import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { LoginComponent } from "./login/login.component";
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { ForgotUsernameComponent } from './forgot-username/forgot-username.component';
import { HomeComponent } from "./home/home.component";

import { ListUploadedFilesComponent } from "./getAccountHistory/getAccountHistory.component";
import { AddUploadedFileComponent } from "./depositMoney/depositMoney.component";
import { EditOfferComponent } from './edit-offer/edit-offer.component';

import { AuthenticationGuardService } from './auth/authentication-guard.service';

const routes: Routes = [

	{ path: 'login', component: LoginComponent },
	{ path: 'forgot-password', component: ForgotPasswordComponent },
	{ path: 'forgot-username', component: ForgotUsernameComponent },
	{ path: '', component: HomeComponent },
	
	{ path: 'getAccountHistory', component: ListUploadedFilesComponent, canActivate: [AuthenticationGuardService] },
	{ path: 'depositMoney', component: AddUploadedFileComponent},
	{ path: 'edit-offer', component: EditOfferComponent},
];

export const routing = RouterModule.forRoot(routes);
