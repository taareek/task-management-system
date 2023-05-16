import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserRegisterComponent } from './user-register/user-register.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FontAwesomeModule,FaIconLibrary } from '@fortawesome/angular-fontawesome';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

// importing necessry font-awesome icons
import { faFilm,faFish } from '@fortawesome/free-solid-svg-icons';

// importing all available font-awesome icons
import { fas } from '@fortawesome/free-solid-svg-icons';
import { far } from '@fortawesome/free-regular-svg-icons';
import { fab }  from '@fortawesome/free-brands-svg-icons';
import { UserHomeComponent } from './user-home/user-home.component'
import { HttpClientModule } from '@angular/common/http';
import { HeaderComponent } from './header/header.component';
import { NavbarComponent } from './navbar/navbar.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
// angular material sidenav
import { MatSidenavModule } from '@angular/material/sidenav';
import {MatListModule} from '@angular/material/list'; 
import { MatIconModule } from '@angular/material/icon';
import {MatToolbarModule} from '@angular/material/toolbar'; 
// created components
import { CreateTaskCollection } from './create-task-collection/create-task-collecton.component';
import { TaskCollectionComponent } from './task-collection/task-collection.component';
import { CreatTaskComponent } from './creat-task/creat-task.component';
import { CreateTaskLogComponent } from './create-task-log/create-task-log.component';
import { ViewTasksComponent } from './view-tasks/view-tasks.component';

@NgModule({
  declarations: [
    AppComponent,
    UserRegisterComponent,
    UserLoginComponent,
    UserHomeComponent,
    HeaderComponent,
    NavbarComponent,
    CreateTaskCollection,
    TaskCollectionComponent,
    CreatTaskComponent,
    CreateTaskLogComponent,
    ViewTasksComponent,
  ],
  imports: [
    BrowserModule,
    NgbModule,
    AppRoutingModule,
    FontAwesomeModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatSidenavModule,
    MatListModule,
    MatIconModule,
    MatToolbarModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { 
  constructor(library: FaIconLibrary){
    //to use specific icons
    // library.addIcons(faFilm, faFish);
    // to use all icons 
    library.addIconPacks(fas, far, fab);
  }
}
