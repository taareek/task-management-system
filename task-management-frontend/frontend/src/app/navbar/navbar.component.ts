import { Component } from '@angular/core';
import { MatSidenavModule } from '@angular/material/sidenav';
import {MatListModule} from '@angular/material/list';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent {
  screenWidth!: number;

  constructor(){
    this.screenWidth = window.innerWidth;
    window.onresize = ()=>{
      this.screenWidth = window.innerWidth;
    }
  }

}
