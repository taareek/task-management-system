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
    designation: ['']
  });

  constructor(
    private fb:FormBuilder,
    private registerService: RegisterService,
    private router: Router,
    private http: HttpClient,
    private appComponent: AppComponent
    ){}

  // user:User = new User();
  ngOnInit(): void {
    
  }
  userRegister(): void{
    
    // this.user = this.registrationForm.value;
    // console.log(this.registrationForm.value);
    const user: User = this.registrationForm.value as User;
    console.log(user);
    this.registerService.registerUser(user).subscribe((registrationData: any) => {
      console.log(registrationData);
    });
    // this.http.post<any>("http://localhost:8090/api/user/user-registration", this.registrationForm.value, {responseType:'json'})
    // .subscribe((resultData: any)=>{
    //       console.log(resultData);
    //       alert("Registration Success!!");
    //       this.registrationForm.reset();
    //       this.router.navigate(["login"]);
    //     }
    //    )
  }
}
