import {Component, OnInit, NgModule, ViewChild, Output, EventEmitter} from '@angular/core';
import {Product} from './model/product';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {ProductService} from '../services/productService';
import {CartService} from '../services/cartService';
import {ProductDetailsComponent} from '../product-details/product-details.component';


@Component({
  selector: 'app-productscomponent',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css'],
  providers: [ProductService],
})
export class ProductsComponent implements OnInit {

  productsByCategoryMap: Map<String,Product[]>;


  constructor(private productService: ProductService, private modalService: NgbModal, private cartService: CartService) {

  }

  ngOnInit() {
    this.groupByProducts();
  }

  openProductDetails(product: Product, $event) {
    $event.stopPropagation();
    const productComponent = this.modalService.open(ProductDetailsComponent);
    productComponent.componentInstance.product = product
  }

  groupByProducts(): void {
    this.productService.getProducts().then(products => {
      this.productsByCategoryMap = new Map<String,Product[]>();
      console.log(products);
      products.forEach(product => {
        product.category.forEach(cat => {
          if (this.productsByCategoryMap.get(cat) === undefined) {
            this.productsByCategoryMap.set(cat, new Array<Product>());
          }
          this.productsByCategoryMap.get(cat).push(this.createProduct(product));
        });
      });
    });
  }


  createProduct(data): Product {
    return new Product(data.productID
      , data.category
      , data.subCategory
      , data.images
      , data.price
      , data.priceAfterDiscount
      , data.discount
      , data.discountLabel
      , data.priceLabel
      , data.name
      , data.title
      , data.description
      , data.availableQuantity
      , data.stars
      , data.label
    )
  }

  addToCart(product: Product, parent) {
    this.cartService.addToCart(product);
  }

  alreadyExistsInCart(product: Product): boolean {
    return this.cartService.checkExistsInCart(product);
  }


}
