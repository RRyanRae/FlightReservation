import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DataService } from 'src/app/services/data.service';
@Component({
  selector: 'app-checkin',
  templateUrl: './checkin.component.html',
  styleUrls: ['./checkin.component.css'],
})
export class CheckinComponent implements OnInit {
  data: any;
  data2: any;
  noOfBags: any;
  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private dataService: DataService
  ) {}

  ngOnInit(): void {
    var id: any = this.route.snapshot.paramMap.get('id');
    console.log(id);
    this.dataService.getReservation(id).subscribe((res) => {
      this.data = res;
    });
  }
  checkin(noOfBags: any) {
    var checkinRequest = {
      id: this.data.id,
      checkedIn: true,
      numberOfBags: noOfBags,
    };

    this.dataService.checkin(checkinRequest).subscribe((res) => {
      this.data2 = res;
    });
    this.router.navigate(['/confirm']);
  }
}
