import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AppComponent } from '../app.component';

@Component({
    selector: 'app-user-home',
    templateUrl: './create-task-collection.component.html',
    styleUrls: ['./create-task-collection.component.scss']
  })
  export class CreateTaskCollection implements OnInit{
    constructor(
        private fb:FormBuilder,
    private http:HttpClient,
    private router: Router,
    private appComponent: AppComponent
    ){}

    ngOnInit(): void {
        this.appComponent.showSideNav = false;
      }
  }
