import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TaskCollection } from './task-collection';

@Injectable({
  providedIn: 'root'
})
export class TaskCollectionService {
  
  baseUrlPost = "http://localhost:8090/api/task-collection/create";
  constructor(private httpClient: HttpClient) { }

  public createTaskCollection(taskCollection?: TaskCollection): Observable<any>{
    return this.httpClient.post<Object>(`${this.baseUrlPost}`, taskCollection);
  }

  // to get all task collections
  baseUrlGet = "http://localhost:8090/api/task-collection/all-task_collections";
  public getAllTask(): Observable<TaskCollection[]>{
    return this.httpClient.get<TaskCollection[]>(`${this.baseUrlGet}`);
  }

  // update a task collction
  // delete a task collection
}
