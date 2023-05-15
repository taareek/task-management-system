import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AppComponent } from '../app.component';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.scss']
})
export class UserLoginComponent implements OnInit {
  logInForm = this.fb.group({
    email: ['', Validators.email],
    password: ['', Validators.required]
  });
  constructor(
    private fb:FormBuilder,
    private http:HttpClient,
    private router: Router,
    private appComponent: AppComponent
    )
    {}
ngOnInit(): void {
  this.appComponent.showSideNav = false;
}
    userLogin(){
      this.http.post<any>("http://localhost:8090/api/user/user-login", this.logInForm.value)
      .subscribe((resultData: any)=>{
        console.log(resultData);
        if(resultData.status==true){
          console.log(resultData.response);
          alert("Log in Successful");
          this.logInForm.reset();
          this.router.navigate(["home"])
        }else{
          console.log(resultData.response);
          alert("Log in Failed!")
        }   
      })
    }
}
