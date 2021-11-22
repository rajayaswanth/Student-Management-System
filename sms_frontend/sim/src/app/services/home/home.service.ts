import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HomeService {

  constructor(private httpClient: HttpClient) { }

  private getLoggedInUserURL = "/api/users/getLoggedInUser";
  headers = new HttpHeaders()
            .set("Authorization", "Bearer " + localStorage.getItem("token"))
            .set("content-type","application/json");

  public getLoggedInUser() {
    return this.httpClient.get(this.getLoggedInUserURL, { 'headers': this.headers });
  }

}
