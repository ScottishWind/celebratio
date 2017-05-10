import {Component, OnInit} from '@angular/core';
import {Product} from '../products/model/product';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  productList: Array<Product>;

  constructor() {
    this.productList = new Array<Product>();
  }

  ngOnInit() {
  }

  addToCart(product: Product) {
    this.productList.push(product)
  }

  removeFromCart(product: Product) {

  }

  size() {
    return this.productList.length;
  }

}
