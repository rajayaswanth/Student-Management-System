import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private fb:FormBuilder, private router: Router) { }

  ngOnInit(): void {
  }

  public form= this.fb.group({
    email:[null, Validators.required],
    password:[null, Validators.required]
  });

  login() {
    console.log(this.form.value)
  }

  register() {
    this.router.navigate(["/register"]);
  }


}
