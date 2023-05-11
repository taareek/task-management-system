import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserRegisterComponent } from './user-register/user-register.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { UserHomeComponent } from './user-home/user-home.component';

const routes: Routes = [
  {
    path: 'registration',
    component: UserRegisterComponent
  },
  {
    path:'login',
    component: UserLoginComponent
  },
  {
    path: 'home',
    component: UserHomeComponent
  },
  // {
  //   path: '', 
  //   redirectTo: 'home', 
  //   pathMatch: 'full'
  // }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
