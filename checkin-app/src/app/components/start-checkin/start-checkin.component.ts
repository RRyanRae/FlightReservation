import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-start-checkin',
  templateUrl: './start-checkin.component.html',
  styleUrls: ['./start-checkin.component.css'],
})
export class StartCheckinComponent implements OnInit {
  reservationId: any;
  constructor(private router: Router) {}

  ngOnInit(): void {}

  onSelect(id: any) {
    this.router.navigate(['/checkin', id]);
  }
}
