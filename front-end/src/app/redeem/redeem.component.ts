import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-redeem',
  templateUrl: './redeem.component.html',
  styleUrls: ['./redeem.component.css']
})
export class RedeemComponent implements OnInit {


  sixOrLess: [] = [];

  eightOrLess: [] = [];

  twelve: [] = [];

product1 = {
  productName: 'Wings',
  pointsNeeded: 200
}

product2 = {
  productName: 'Wings',
  pointsNeeded: 200
}

product3 = {
  productName: 'Wings',
  pointsNeeded: 200
}

product4 = {
  productName: 'Wings',
  pointsNeeded: 200
}


threeOrLess = [this.product1, this.product2, this.product3, this.product4];

  constructor() { }

  ngOnInit(): void {
  }

 firstSection = document.getElementById('section1')
  

}
