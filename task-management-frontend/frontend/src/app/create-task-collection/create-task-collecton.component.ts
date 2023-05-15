import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AppComponent } from '../app.component';
import { ActivatedRoute } from "@angular/router";
import { TaskCollection } from '../task-collection';
import { TaskCollectionService } from '../task-collection.service';

@Component({
    selector: 'app-user-home',
    templateUrl: './create-task-collection.component.html',
    styleUrls: ['./create-task-collection.component.scss']
  })
  export class CreateTaskCollection implements OnInit{

    // taskColledtionID: number | null;
    createTaskForm = this.fb.group({
      id:[''],
      taskCollectionName: ['', Validators.required]
      });

    constructor(
      private fb:FormBuilder,
      private http:HttpClient,
      private router: Router,
      private appComponent: AppComponent,
      private route: ActivatedRoute,
      private taskCollectionService: TaskCollectionService
      // this.askColledtionID: null;
    ){}

    taskCollection: TaskCollection = new TaskCollection();
    ngOnInit(): void {
        this.appComponent.showSideNav = false;
      }

    

    createTask(){
      console.log(this.createTaskForm.value);
      this.taskCollection = this.createTaskForm.value as TaskCollection;
      console.log(this.taskCollection);
      const createTaskFormData = this.createTaskForm.value;
      if(createTaskFormData.taskCollectionName === ""){
        alert("Task collection must have a name!")
      }else{
        this.taskCollectionService.createTaskCollection(this.taskCollection).subscribe(
          (taskCollectionData: any)=>{
            if(taskCollectionData.status){
              alert("Task Collection Created!!");
              this.createTaskForm.reset();
              //this.router.navigate(["login"]) routed to be task collection page;
            }
          }
        );
      }
    }   
  }
