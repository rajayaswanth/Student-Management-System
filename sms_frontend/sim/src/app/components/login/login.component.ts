import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private fb:FormBuilder, private router: Router, private loginService: LoginService) { }

  ngOnInit(): void {
  }

  public form= this.fb.group({
    username:[null, Validators.required],
    password:[null, Validators.required]
  });

  login() {
    console.log(this.form.value)
    this.loginService.authenticate(this.form.value).subscribe((data: any) => {
      localStorage.setItem("token",data.token);
    },
    error => alert("UnAuthorized"));
  }

  register() {
    this.router.navigate(["/register"]);
  }


}
