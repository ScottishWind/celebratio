import {Component, OnInit, Input, ViewChild} from '@angular/core';
import {NgbActiveModal} from '@ng-bootstrap/ng-bootstrap';
import {Product} from '../products/model/product';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})

export class ProductDetailsComponent {
  @Input() product;
  @ViewChild('mainImage') mainImage;

  constructor(public activeModal: NgbActiveModal) {
  }

}


