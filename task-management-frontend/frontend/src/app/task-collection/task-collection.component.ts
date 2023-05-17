import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AppComponent } from '../app.component';
import { TaskCollectionService } from '../task-collection.service';
import { TaskCollection } from '../task-collection';

@Component({
  selector: 'app-task-collection',
  templateUrl: './task-collection.component.html',
  styleUrls: ['./task-collection.component.scss']
})
export class TaskCollectionComponent implements OnInit{

  allTaskCollection!: TaskCollection[];

  constructor(
    private http:HttpClient,
    private router: Router,
    private appComponent: AppComponent,
    private route: ActivatedRoute,
    private taskCollectionService: TaskCollectionService,
    // private allTaskCollection : TaskCollection[]
    // this.allTaskCollection = [];
  ){}

  taskCollection: TaskCollection = new TaskCollection();

  ngOnInit(): void {
    this.appComponent.showSideNav = false;
    this.getAllTaskCollection();
  }

  getAllTaskCollection(){
    this.taskCollectionService.getAllTask().subscribe(
      (taskCollections: any )=> {
        // console.log(taskCollections);
        this.allTaskCollection = taskCollections
        // console.log(this.allTaskCollection)
      })
  }

  addTaskCollection(){
    this.router.navigate(["create-task-collection"]);
  }
}

