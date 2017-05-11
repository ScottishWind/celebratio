import {Component, OnInit, OnDestroy} from '@angular/core';
import {Product} from '../products/model/product';
import {Subscription} from 'rxjs/Subscription';
import {CartService} from '../services/cartService';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent {

  productList: Product[] = new Array<Product>();
  subscription: Subscription;

  constructor(private cartService: CartService) {
    this.cartService.getProductList().subscribe(productList => {
      this.productList = productList;
    });
  }


  removeFromCart(product: Product) {

  }


}
