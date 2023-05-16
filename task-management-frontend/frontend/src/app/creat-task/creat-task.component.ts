import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AppComponent } from '../app.component';
import { TaskPriorityLevel, TaskPriorityLevelToLabel } from '../enums/task-priority.model';
import { Task } from '../task';
import { taskStatus } from '../enums/task-status.model';
import { TaskCollection } from '../task-collection';
import { TaskService } from '../task.service';

@Component({
  selector: 'app-creat-task',
  templateUrl: './creat-task.component.html',
  styleUrls: ['./creat-task.component.scss']
})
export class CreatTaskComponent implements OnInit{

  createTaskForm = this.fb.group({
    id:[],
    taskName:['', Validators.required],
    description:[],
    createdAt:[],
    dueDate: [ Validators.required],
    expectedTime:[ Validators.required],
    taskPriorityLevel:[],
    taskStatus:[],
    hasReminder:[],
    taskCollection:[]
  })

  constructor(
    private fb:FormBuilder,
      private http:HttpClient,
      private router: Router,
      private appComponent: AppComponent,
      private taskService: TaskService
  ){}
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

    // let request = {
    //   id: this.createTaskForm.value.id,
    //   taskName: this.createTaskForm.value.taskName,
    //   description: this.createTaskForm.value.description,
    //   createdAt: this.createTaskForm.value.createdAt,
    //   dueDate: this.createTaskForm.value.dueDate,
    //   expectedTime: this.createTaskForm.value.expectedTime,
    //   taskPriorityLevel: this.createTaskForm.value.taskPriorityLevel,
    //   taskStatus: this.createTaskForm.value.taskStatus,
    //   hasReminder: this.createTaskForm.value.hasReminder,
    //   taskCollection: parseInt(this.createTaskForm.get('taskCollection')?.value) , value.taskCollection
    // };

    this.task = this.createTaskForm.value as unknown as Task;
    console.log(this.task);
    if(this.createTaskForm.value.taskName === ""){
      alert("Task must have a name")
    }else{
      this.taskService.createTask(this.task).subscribe(
        (taskData: any)=>{
          alert("Task created");
          this.createTaskForm.reset();
        }
      );
    }
  }
}
