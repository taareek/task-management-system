import { Component } from '@angular/core';
import { faEdit, faUserEdit } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'frontend';
  userEdit = faUserEdit;
  // screenWidth!:number;
  // if it is true then it will use side navbar
  showSideNav = false;
  constructor(){
    // this.screenWidth = window.innerWidth;
    // window.onresize = ()=>{
    //   this.screenWidth = window.innerWidth;
    // }
  }
}
