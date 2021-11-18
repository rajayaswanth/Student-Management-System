import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private httpClient: HttpClient) { }

  private getUrl = "/api/authenticate";

  public authenticate(requestBody:any) {
    const body = requestBody;
    return this.httpClient.post(this.getUrl, body);
  }

}
