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
  showSideNav = true;
  constructor(){
    // this.screenWidth = window.innerWidth;
    // window.onresize = ()=>{
    //   this.screenWidth = window.innerWidth;
    // }
  }
}
