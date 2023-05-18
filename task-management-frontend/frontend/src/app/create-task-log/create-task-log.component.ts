import { OnInit } from '@angular/core';
import { Component } from '@angular/core';
import { TaskLogServiceService } from '../task-log-service.service';
import { AppComponent } from '../app.component';
import { HttpClient } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { TaskLog } from '../task-log';
import { TaskService } from '../task.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-task-log',
  templateUrl: './create-task-log.component.html',
  styleUrls: ['./create-task-log.component.scss']
})
export class CreateTaskLogComponent implements OnInit{

  createTaskLogForm = this.fb.group({
    id:[],
    spentTime:[''],
    logNote:[],
    logDate:[],
    task: this.fb.group({
      id:[]
    }
    ),
  })  

  allTasks: any;

  constructor(
    private fb:FormBuilder,
    private appComponent: AppComponent,
    private taskLogService: TaskLogServiceService,
    private taskService: TaskService,
    private router: Router,
  ){}
  taskLog : TaskLog = new TaskLog();
  ngOnInit(): void {
    this.getAllTasks();
  }

  getAllTasks(){
    this.taskService.getAlltasks().subscribe(
      (taskCollections: any )=> {
        this.allTasks = taskCollections;
        console.log(this.allTasks)
      })
  }

  createTaskLog(){
    console.log(this.createTaskLogForm.value)
    this.taskLog = this.createTaskLogForm.value as unknown as TaskLog;
    if(this.taskLog.logNote === ""){
      alert("task log must have a note!")
    }else{
      this.taskLogService.createTaskLog(this.taskLog).subscribe(
        (taskLogData: any)=>{
          // alert("task log created!")
          this.createTaskLogForm.reset();
          this.router.navigate(["view-task-logs"]);
        }
      )
    }
  }
}
