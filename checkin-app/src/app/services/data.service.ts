import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class DataService {
  private apiUrl = 'http://localhost:8080/flightReservation/reservations/';
  constructor(private http: HttpClient) {}

  getReservation(id: number) {
    return this.http.get(this.apiUrl + id);
  }

  checkin(checkinRequest: any) {
    return this.http.post(this.apiUrl, checkinRequest);
  }
}
