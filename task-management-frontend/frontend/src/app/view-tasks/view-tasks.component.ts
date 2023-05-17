import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AppComponent } from '../app.component';
import { Task } from '../task';
import { TaskService } from '../task.service';

@Component({
  selector: 'app-view-tasks',
  templateUrl: './view-tasks.component.html',
  styleUrls: ['./view-tasks.component.scss']
})
export class ViewTasksComponent implements OnInit{

  allTasks!:Task[];

  constructor(
    private http: HttpClient,
    private router: Router,
    private appComponent: AppComponent,
    private route: ActivatedRoute,
    private taskService: TaskService
  ){}

  ngOnInit(): void {
    this.appComponent.showSideNav = false;
    this.getAllTasks();

  }

  getAllTasks(){
    this.taskService.getAlltasks().subscribe(
      (allTasksData: any)=>{
        console.log(allTasksData);
        this.allTasks = allTasksData;
      }
    )
  }
  addTask(){
    this.router.navigate(["create-task"]);
  }
}
