import {Component, OnInit, OnDestroy} from '@angular/core';
import {Product} from '../products/model/product';
import {Subscription} from 'rxjs/Subscription';
import {CartService} from '../services/cartService';
import {Router} from '@angular/router';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent {

  productList: Product[] = new Array<Product>();
  subscription: Subscription;

  constructor(private cartService: CartService, private router: Router) {
    this.cartService.getProductList().subscribe(productList => {
      this.productList = productList;
    });
  }


  removeFromCart(product: Product) {
    this.cartService.removeFromCart(product);
  }

  stopClosing($event) {
    if (this.productList.length > 0) {
      $event.stopPropagation();
    }
  }

  addQty(value: string) {
    return parseInt(value) + 1;
  }

  removeQty(value: string, product: Product) {
    if (value == '1') {
      this.removeFromCart(product);
    }
    return parseInt(value) - 1;
  }


}
