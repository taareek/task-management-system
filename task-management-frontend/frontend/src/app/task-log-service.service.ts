import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { TaskLog } from './task-log';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TaskLogServiceService {
  postUrl = "http://localhost:8090/api/tasks/logs/create";

  constructor(private httpClient: HttpClient) { }
  // create
  public createTaskLog(taskLog?: TaskLog): Observable<any>{
    return this.httpClient.post<any>(`${this.postUrl}`, taskLog);
  }
  // get
  getUrl = "http://localhost:8090/api/tasks/logs/all-logs"
  public getAllTaskLog(): Observable<TaskLog[]>{
      return this.httpClient.get<TaskLog[]>(`${this.getUrl}`);
  }
  // update
  // delete
}
