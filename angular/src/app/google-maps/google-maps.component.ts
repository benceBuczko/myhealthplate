import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-google-maps',
  templateUrl: './google-maps.component.html',
  styleUrls: ['./google-maps.component.scss']
})
export class GoogleMapsComponent implements OnInit {

  lat: number = 47.505028;
  lng: number = 19.057968;
  zoom: number = 18;

  constructor() { }

  ngOnInit() {
  }

}
