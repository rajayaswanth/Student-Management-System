import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HomeService } from 'src/app/services/home/home.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  activeNav = "about"
  path = ''
  showImage = false;
  person = {
    email:'',
    firstName:'',
    lastName:'',
    userType:'',
    mobile:'',
    phone:'',
    dob:'',
    doj:''
  };

  constructor(private router: Router, private homeService: HomeService) { }

  ngOnInit(): void {
    this.getLoggedInUser();
  }

  getLoggedInUser() {
    this.homeService.getLoggedInUser().subscribe((data: any) => {
      if(data.status === 'SUCCESS' && data.data.user != null) {
        this.person.email = data.data.email;
        this.person.firstName = data.data.user.firstName;
        this.person.lastName = data.data.user.lastName;
        this.person.userType = data.data.userType;
        this.person.mobile = data.data.user.mobile;
        this.person.dob = data.data.user.dob;
        this.person.doj = data.data.user.doj;
      }
    })
  }

  changeNav(selectedNav: any) {
    this.activeNav = selectedNav;
  }

  fileData(data:any) {
    console.log(data.target.value);
    this.path = data.target.value;
    this.showImage = !this.showImage;
  }

  logout() {
    this.router.navigate([""]);
    localStorage.clear();
  }

}
