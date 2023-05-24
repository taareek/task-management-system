import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserRegisterComponent } from './user-register/user-register.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { UserHomeComponent } from './user-home/user-home.component';
import { CreateTaskCollection } from './create-task-collection/create-task-collecton.component';
import { CreatTaskComponent } from './creat-task/creat-task.component';
import { CreateTaskLogComponent } from './create-task-log/create-task-log.component';
import { TaskCollectionComponent } from './task-collection/task-collection.component';
import { ViewTasksComponent } from './view-tasks/view-tasks.component';
import { ViewTaskLogComponent } from './view-task-log/view-task-log.component';
import { UpdateTaskComponent } from './update-task/update-task.component';
import { DemoJsonForms } from './demo-json-forms/demo-json-forms.component';
import { UpdateTaskLogsComponent } from './update-task-logs/update-task-logs.component';


const routes: Routes = [
  {path: 'registration', component: UserRegisterComponent},
  {path:'login', component: UserLoginComponent},
  {path: 'home', component: UserHomeComponent},
  {path: 'create-task-collection', component: CreateTaskCollection},
  {path:'create-task', component: CreatTaskComponent},
  {path: '', 
    redirectTo: 'login', 
    pathMatch: 'full',
  },
  {path: 'create-task-log', component: CreateTaskLogComponent},
  {path: 'task-collection', component:TaskCollectionComponent},
  {path: 'view-tasks', component:ViewTasksComponent},
  {path: 'view-task-logs', component:ViewTaskLogComponent},
  {path: 'update-task/:id', component:UpdateTaskComponent},
  {path: 'json-forms', component:DemoJsonForms},
  {path: 'update-task-logs/:id', component:UpdateTaskLogsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
