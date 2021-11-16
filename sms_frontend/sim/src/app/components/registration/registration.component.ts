import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  constructor(private fb:FormBuilder, private router: Router) { }

  activeType = 'Parent';

  ngOnInit(): void {
  }

  public form= this.fb.group({
    firstName:[null, Validators.required],
    lastName:[null, Validators.required],
    email:[null, Validators.required],
    password:[null, Validators.required],
    phone:[null],
    mobile:[null, Validators.required],
    userType:[null]
  });

  userTypes = [
    'Parent',
    'Teacher'
  ]

  setTypeAsActive(userType: any) {
    this.activeType = userType;
  }

  login() {
    this.router.navigate([""]);
  }

  register() {
    this.form.get("userType")?.setValue(this.activeType)
    console.log(this.form.value)
  }

}
