import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { jsonFormData } from '../demo-json-forms/demo-json-forms.component';

@Component({
  selector: 'app-user-home',
  templateUrl: './user-home.component.html',
  styleUrls: ['./user-home.component.scss']
})


export class UserHomeComponent implements OnInit{

  public formData!: jsonFormData;

  constructor (
    private http: HttpClient
  ){}

  ngOnInit(): void {
    // this.http
    // .get('/asset/my-form.json')
    // .subscribe((this.formData: jsonFormdata)=>{
    //   this.formData = this.formData;
    // });
  }
}
