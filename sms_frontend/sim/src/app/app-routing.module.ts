import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { RegistrationComponent } from './components/registration/registration.component';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { StudentComponent } from './components/student/student.component';
import { ParentComponent } from './components/parent/parent.component';
import { TeacherComponent } from './components/teacher/teacher.component';

const routes: Routes = [
  {path:'', component:LoginComponent},
  {path:'register', component:RegistrationComponent},
  {path:'home', component:HomeComponent},
  {path:'student', component:StudentComponent},
  {path:'parent', component:ParentComponent},
  {path:'teacher', component:TeacherComponent}
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ]
})
export class AppRoutingModule { }
