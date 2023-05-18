import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Task } from './task';
import { Observable } from 'rxjs';
import { TaskCollection } from './task-collection';

@Injectable({
  providedIn: 'root'
})
export class TaskService {
  postUrl = "http://localhost:8090/api/tasks/create";
  constructor(private httpClient: HttpClient) { }

  public createTask(task?: Task): Observable<any>{
    return this.httpClient.post<any>(`${this.postUrl}`, task);
  }

  // get all tasks
  getUrl = "http://localhost:8090/api/tasks/all-tasks";
  public getAlltasks():Observable<Task[]>{
    return this.httpClient.get<Task[]>(`${this.getUrl}`);
  }

  // get all task collections
  baseUrlGet = "http://localhost:8090/api/task-collection/all-task_collections";
  public getAllTask(): Observable<TaskCollection[]>{
    return this.httpClient.get<TaskCollection[]>(`${this.baseUrlGet}`);
  }

  // get task by id 
  getIdUrl = "http://localhost:8090/api/tasks/task-id";
  public getTaskById(id: any): Observable<Task>{
    return this.httpClient.get<Task>(`${this.getIdUrl}/${id}`)
  }

  // update task by activated Id
  updateUrl = "http://localhost:8090/api/tasks/update"
  public updateTask(id?: any, task?: Task): Observable<Object>{
    return this.httpClient.put(`${this.updateUrl}/${id}`, task)
  }
}
