import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Router, ActivatedRoute } from "@angular/router";
import { ApiService } from "../core/api.service";
import { AppComponent } from '../app.component';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  invalidLogin: boolean = false;
  returnUrl: string;

  constructor(
    private route: ActivatedRoute,
    private formBuilder: FormBuilder,
    private router: Router,
    private apiService: ApiService) { }

  onSubmit() {
    
    if (this.loginForm.invalid) {
      return;
    }
    
    const loginPayload = {
      username: this.loginForm.controls.username.value,
      password: this.loginForm.controls.password.value
    }

    this.apiService.login(loginPayload).subscribe(data => {

      if (data.status === 200) {

        this.apiService.loginEvent(data.result.token, data.result.username);

        // login successful so redirect to return url
        this.router.navigateByUrl(this.returnUrl);

      } else {
        this.invalidLogin = true;
        alert(data.message);
      }
    });
  }

  ngOnInit() {

    this.apiService.logoutEvent();

    this.loginForm = this.formBuilder.group({
      username: ['noureddinebahri', Validators.compose([Validators.required])],
      password: ['NoureddineBahriFakePassword', Validators.required]
    });

    // get return url from route parameters or default to '/'
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
  }

  forgotPassword(): void {
    this.router.navigate(['forgot-password']);
  };

  forgotUsername(): void {
    this.router.navigate(['forgot-username']);    
  };

  signIn(): void {
    this.router.navigate(['add-user']);    
  };
}
