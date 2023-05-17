import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserRegisterComponent } from './user-register/user-register.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { UserHomeComponent } from './user-home/user-home.component';
import { CreateTaskCollection } from './create-task-collection/create-task-collecton.component';
import { CreatTaskComponent } from './creat-task/creat-task.component';
import { CreateTaskLogComponent } from './create-task-log/create-task-log.component';

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
  {
    path: 'create-task-collection',
    component: CreateTaskCollection
  },
  {
    path:'create-task',
    component: CreatTaskComponent
  },
  {
    path: '', 
    redirectTo: 'login', 
    pathMatch: 'full',
  },
  {
    path: 'create-task-log',
    component: CreateTaskLogComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
