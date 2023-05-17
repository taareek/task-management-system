import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AppComponent } from '../app.component';
import { TaskPriorityLevel, TaskPriorityLevelToLabel } from '../enums/task-priority.model';
import { Task } from '../task';
// import { taskStatus } from '../enums/task-status.model';
import { TaskCollection } from '../task-collection';
import { TaskService } from '../task.service';
import { getLocaleDateFormat } from '@angular/common';



@Component({
  selector: 'app-creat-task',
  templateUrl: './creat-task.component.html',
  styleUrls: ['./creat-task.component.scss']
})
export class CreatTaskComponent implements OnInit{

  createTaskForm = this.fb.group({
    id:[],
    taskName:[''],
    description:[],
    createdAt:[],
    dueDate: [ ],
    expectedTime:[],
    taskPriorityLevel:[],
    taskStatus:[],
    hasReminder:[],
    taskCollection: this.fb.group({
      id:[],
      taskCollectionName:[]
    }
    ),
  })

  constructor(
    private fb:FormBuilder,
      private http:HttpClient,
      private router: Router,
      private appComponent: AppComponent,
      private taskService: TaskService,
      
  ){}
  // trying to pass drop-down list values as enums
  // public TaskPriorityLevelToLabel = TaskPriorityLevelToLabel;
  // public priorityLabels = Object.values(TaskPriorityLevel);
  // priorityLevels: TaskPriorityLevel[] = [];
  task: Task = new Task();

  ngOnInit(): void {
    this.appComponent.showSideNav = false;
    // this.priorityLevels = Object.values(TaskPriorityLevel);
    // console.log(typeof(this.priorityLevels))
    // console.log(this.priorityLevels)  
  }

  createTask(){
    console.log(this.createTaskForm.value);
    this.task = this.createTaskForm.value as unknown as Task;
    console.log(this.task);
    if(this.createTaskForm.value.taskName === ""){
      alert("Task must have a name")
    }else{
      this.taskService.createTask(this.task).subscribe(
        (taskData: any)=>{
          // alert("Task created");
          this.createTaskForm.reset();
          this.router.navigate(["view-tasks"]);
        }
      );
    }
  }
}
