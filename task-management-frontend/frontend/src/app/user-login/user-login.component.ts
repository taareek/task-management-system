import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.scss']
})
export class UserLoginComponent {
  logInForm = this.fb.group({
    email: ['', Validators.email],
    password: ['', Validators.required]
  });
  constructor(private fb:FormBuilder){}
}
