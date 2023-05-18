import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AppComponent } from '../app.component';
import { TaskService } from '../task.service';
import { TaskCollectionService } from '../task-collection.service';
import { Task } from '../task';
import { faThemeisle } from '@fortawesome/free-brands-svg-icons';

@Component({
  selector: 'app-user-home',
  templateUrl: './update-task.component.html',
  styleUrls: ['./update-task.component.scss']
})
export class UpdateTaskComponent implements OnInit {
    
    createTaskForm = this.fb.group({
        id:[],
        taskName:[''],
        description:[''],
        createdAt:[''],
        dueDate: ['' ],
        expectedTime:[''],
        taskPriorityLevel:[''],
        taskStatus:[''],
        hasReminder:[],
        taskCollection: this.fb.group({
          id:[''],
          taskCollectionName:['']
        }
        ),
      })
    
    allTaskCollection: any;
    
    constructor(
        private fb:FormBuilder,
          private router: Router,
          private appComponent: AppComponent,
          private taskService: TaskService,
          private taskCollectionService: TaskCollectionService,
          private activatedRoute: ActivatedRoute
          
      ){}
    
    task: Task = new Task();
    id: any;

    ngOnInit(): void {
        this.appComponent.showSideNav = false;
        this.getAllTaskCollections();
        // getting currently activated id
        this.id = this.activatedRoute.snapshot.params['id']
        this.taskService.getTaskById(this.id).subscribe(data=>{
            console.log(data);
            this.task= data;
            this.createTaskForm.get('taskName')?.setValue(this.task.taskName);
            this.createTaskForm.get('description')?.setValue(this.task.description);
            this.createTaskForm.get('dueDate')?.setValue(this.task.dueDate);
            this.createTaskForm.get('expectedTime')?.setValue(this.task.expectedTime);
            this.createTaskForm.get('taskPriorityLevel')?.setValue(this.task.taskPriorityLevel);
            this.createTaskForm.get('taskStatus')?.setValue(this.task.taskStatus);
            // this.createTaskForm.get('taskCollection')?.setValue(this.task.taskCollection.taskCollectionName);
        })
    }

    getAllTaskCollections(){
        this.taskCollectionService.getAllTask().subscribe(
          (taskCollections: any )=> {
            this.allTaskCollection = taskCollections;
            // console.log(this.allTaskCollection)
          })
      }
    
    updateTask(){
        this.taskService.updateTask(this.id, this.task).subscribe(data =>{
            // console.log(data)
            this.router.navigate(["view-tasks"]);

        })
    }
}
