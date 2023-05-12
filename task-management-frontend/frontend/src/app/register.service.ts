import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from './user';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  constructor(private httpClient: HttpClient) { }
  
  public registerUser(user: Partial<User>): Observable<any>{
    const url = 'http://localhost:8090/api/user/user-registration';
    return this.httpClient.post<any>(`${url}`, user);
  }
}
