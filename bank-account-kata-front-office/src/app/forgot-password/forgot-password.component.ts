import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Router, ActivatedRoute } from "@angular/router";
import { ApiService } from "../core/api.service";

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent implements OnInit {

  forgotPasswordForm: FormGroup;
  invalidUsername: boolean = false;
  returnUrl: string;

  constructor(
    private route: ActivatedRoute,
    private formBuilder: FormBuilder,
    private router: Router,
    private apiService: ApiService) { }

  onSubmit() {
    
    if (this.forgotPasswordForm.invalid) {
      return;
    }
    
    const regeneratePasswordPayload = {
      username: this.forgotPasswordForm.controls.username.value
    }

    this.apiService.regeneratePassword(regeneratePasswordPayload).subscribe(data => {

      if (data.status === 200) {

        // regeneratePassword successful so redirect to return url
        this.router.navigateByUrl(this.returnUrl);

      } else {
        this.invalidUsername = true;
        alert(data.message);
      }
    });
  }

  ngOnInit() {

    this.forgotPasswordForm = this.formBuilder.group({
      username: ['wchaouachi', Validators.compose([Validators.required])]
    });

    // get return url from route parameters or default to '/'
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/'; 
  }
}
