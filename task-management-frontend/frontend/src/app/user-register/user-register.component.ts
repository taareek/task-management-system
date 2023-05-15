import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AppComponent } from '../app.component';
import { User } from '../user';
import { RegisterService } from '../register.service';

@Component({
  selector: 'app-user-register',
  templateUrl: './user-register.component.html',
  styleUrls: ['./user-register.component.scss']
})
export class UserRegisterComponent implements OnInit{

  registrationForm = this.fb.group({
    firstName: [''],
    lastName: [''],
    address:[''],
    userName:[''],
    email:[''],
    password: [''],
    userDesignation: ['']
  });

  constructor(
    private fb:FormBuilder,
    private registerService: RegisterService,
    private router: Router,
    private http: HttpClient,
    private appComponent: AppComponent
    ){}

  private userDetails :User = new User();
  ngOnInit(): void {
    this.appComponent.showSideNav = true;
  }
  userRegister(): void{
    this.userDetails = this.registrationForm.value as User;
    console.log(this.userDetails);
    this.registerService.registerUser(this.userDetails).subscribe((registrationData: any) => {
      console.log(registrationData);
      if(registrationData.status){
        alert("Registration Success!!");
        this.registrationForm.reset();
        this.router.navigate(["login"]);
      }else{
        alert("Registration Failed!!");
      }
    });
  
  }
}
