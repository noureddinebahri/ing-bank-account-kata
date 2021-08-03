import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Router, ActivatedRoute } from "@angular/router";
import { ApiService } from "../core/api.service";

@Component({
  selector: 'app-forgot-username',
  templateUrl: './forgot-username.component.html',
  styleUrls: ['./forgot-username.component.css']
})
export class ForgotUsernameComponent implements OnInit {

  forgotUsernameForm: FormGroup;
  invalidEmail: boolean = false;
  returnUrl: string;

  constructor(
    private route: ActivatedRoute,
    private formBuilder: FormBuilder,
    private router: Router,
    private apiService: ApiService) { }

  onSubmit() {
    
    if (this.forgotUsernameForm.invalid) {
      return;
    }
    
    const forgotUsernamePayload = {
      email: this.forgotUsernameForm.controls.email.value
    }

    this.apiService.sendUsername(forgotUsernamePayload).subscribe(data => {

      if (data.status === 200) {

        // sendUsername successful so redirect to return url
        this.router.navigateByUrl(this.returnUrl);

      } else {
        this.invalidEmail = true;
        alert(data.message);
      }
    });
  }

  ngOnInit() {

    this.forgotUsernameForm = this.formBuilder.group({
      email: ['contact@bahri-it-services.fr', Validators.compose([Validators.required])]
    });

    // get return url from route parameters or default to '/'
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/'; 
  }
}
