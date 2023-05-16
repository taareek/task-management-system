import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Task } from './task';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TaskService {
  postUrl = "http://localhost:8090/api/tasks/create";
  constructor(private httpClient: HttpClient) { }

  public createTask(task?: Task): Observable<any>{
    return this.httpClient.post<any>(`${this.postUrl}`, task);
  }
}
