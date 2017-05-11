import {Component, OnInit, Input, ViewChild, EventEmitter, Output} from '@angular/core';
import {NgbActiveModal} from '@ng-bootstrap/ng-bootstrap';
import {Product} from '../products/model/product';
import {CartService} from '../services/cartService';


@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})

export class ProductDetailsComponent {
  @Input() product;
  @ViewChild('mainImage') mainImage;
  addedToCart : boolean;

  constructor(public activeModal: NgbActiveModal, private cartService: CartService) {
  }

  addToCart(product: Product) {
    this.cartService.addToCart(product);
  }

  alreadyExistsInCart(product: Product): boolean {
    this.addedToCart =  this.cartService.checkExistsInCart(product);
    return this.addedToCart
  }


}


