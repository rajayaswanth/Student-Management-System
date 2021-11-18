import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { RegistrationService } from 'src/app/services/registration/registration.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  constructor(private fb:FormBuilder, private router: Router, private registerService: RegistrationService) { }

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
    this.registerService.createUser(this.form.value).subscribe((data: any) => {
      console.log(data)
      this.router.navigate([""]);
    },
    error => alert("Unable to create"));
  }

}
