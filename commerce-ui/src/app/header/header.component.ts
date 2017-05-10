import {Component, OnInit, NgModule, ViewChild} from '@angular/core';
import {Product} from '../products/model/product';
import {CartComponent} from '../cart/cart.component';


@Component({
  selector: 'app-headercomponent',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  @ViewChild('cart') cartComponent: CartComponent;

  constructor() {

  }

  ngOnInit() {
  }

  addToCart(product: Product) {
    this.cartComponent.addToCart(product)
  }

}
