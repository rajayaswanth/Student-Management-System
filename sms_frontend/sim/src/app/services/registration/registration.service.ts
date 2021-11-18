import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  constructor(private httpClient: HttpClient) { }

  private addUser = "/api/users/add";

  public createUser(requestBody:any) {
    const body = requestBody;
    return this.httpClient.post(this.addUser, body);
  }

}
