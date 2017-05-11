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

  constructor(public activeModal: NgbActiveModal, private cartService: CartService) {
  }

  addToCart(product: Product) {
    this.cartService.addToCart(product);
    this.activeModal.close('Close click');
  }

  alreadyExistsInCart(product: Product): boolean {
    return this.cartService.checkExistsInCart(product);
  }


}


