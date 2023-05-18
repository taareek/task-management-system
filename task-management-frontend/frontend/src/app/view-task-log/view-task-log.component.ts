import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppComponent } from '../app.component';
import { TaskLogServiceService } from '../task-log-service.service';
import { TaskLog } from '../task-log';

@Component({
  selector: 'app-root',
  templateUrl: './view-task-log.component.html',
  styleUrls: ['./view-task-log.component.scss']
})
export class ViewTaskLogComponent implements OnInit{
    
    allTaskLogsData!: TaskLog[];

    constructor(
        private router: Router,
        private appComponent: AppComponent,
        private taskLogService: TaskLogServiceService
    ){}
  ngOnInit(): void {
    this.appComponent.showSideNav = false;
    this.getAllTaskLogs();
  }

  getAllTaskLogs(){
    this.taskLogService.getAllTaskLog().subscribe(
        (taskLogs: any)=>{
            console.log(taskLogs);
            this.allTaskLogsData = taskLogs;
        }
    )
  }

  addTaskLog(){
    this.router.navigate(['create-task-log']);
  }
}