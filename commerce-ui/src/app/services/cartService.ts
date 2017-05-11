import {Injectable}              from '@angular/core';
import {Product} from '../products/model/product';
import {Observable} from 'rxjs/Observable';
import {Subject} from 'rxjs/Subject';
import {factoryOrValue} from "rxjs/operator/multicast";
import 'rxjs/add/observable/of';


@Injectable()
export class CartService {
  product$: Subject<Product> = new Subject<Product>();
  productList: Product[] = new Array<Product>();

  constructor() {
    this.product$.subscribe(product => {
      this.productList.push(product);
    });
  }


  addToCart(product: Product) {
    this.product$.next(product);
  }

  getProductList(): Observable<Product[]> {
    return Observable.of(this.productList);
  }

  checkExistsInCart(checkProduct: Product): boolean {
    let exists = false;
    this.productList.forEach(product => {
      if (product.productID === checkProduct.productID) {
        exists = true;
      }
    });
    console.log("Returnning ", exists);
    return exists;
  }

  removeFromCart(product: Product) {

  }


}
