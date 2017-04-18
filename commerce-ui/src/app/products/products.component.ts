import {Component, OnInit, NgModule} from '@angular/core';
import {Product} from './model/product';
import {ProductService} from '../services/productService';


@Component({
  selector: 'app-productscomponent',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css'],
  providers: [ProductService]
})
export class ProductsComponent implements OnInit {

  productsByCategory: Map<String,Product[]> = new Map<String,Product[]>();

  constructor(private productService: ProductService) {

  }

  ngOnInit() {
    this.groupByProducts();
  }

  groupByProducts(): void {
    this.productService.getProducts().then(products => {
      products.forEach(product => {
          if (this.productsByCategory.get(product.category) === undefined) {
            this.productsByCategory.set(product.category, new Array<Product>());
          }
          this.productsByCategory.get(product.category).push(this.createProduct(product))
        }
      )
    });
    console.log(this.productsByCategory);
  }

  createProduct(data): Product {
    return new Product(data.category
      , data.subCategory
      , data.image
      , data.discount
      , data.actualPrice
      , data.discountedPrice
      , data.label
      , data.name
      , data.title
      , data.description
    )
  }

}
