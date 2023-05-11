import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AppComponent } from '../app.component';

@Component({
  selector: 'app-user-register',
  templateUrl: './user-register.component.html',
  styleUrls: ['./user-register.component.scss']
})
export class UserRegisterComponent {

  registrationForm = this.fb.group({
    firstName: ['', Validators.required],
    lastName: ['', Validators.required],
    address:[''],
    userName:[''],
    email:['', Validators.email],
    password: ['', Validators.required],
    designation: ['']
  });

  constructor(
    private fb:FormBuilder,
    private http:HttpClient,
    private router: Router,
    private appComponent: AppComponent
    ){}

  userRegister(){
    this.http.post<any>("http://localhost:8090/api/user/user-registration", this.registrationForm.value)
        .subscribe((resultData: any)=>{
          console.log(resultData);
          alert("Registration Success!!");
          this.registrationForm.reset();
          this.router.navigate(["login"]);
        },err=>{
          console.log(err)
          alert("Registration failed!!")
        }
        )
  }
}
