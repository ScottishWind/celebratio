import {Component, OnInit, NgModule} from '@angular/core';
import {Product} from './model/product';
import {ProductService} from '../services/productService';


@Component({
  selector: 'app-productscomponent',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css'],
  providers: [ProductService],
})
export class ProductsComponent implements OnInit {

  productsByCategoryMap: Map<String,Product[]>;

  constructor(private productService: ProductService) {

  }

  ngOnInit() {
    this.groupByProducts();
  }

  groupByProducts(): void {
    this.productService.getProducts().then(products => {
      this.productsByCategoryMap = new Map<String,Product[]>();
      console.log(products);
      products.forEach(product => {
          if (this.productsByCategoryMap.get(product.category) === undefined) {
            this.productsByCategoryMap.set(product.category, new Array<Product>());
          }
          this.productsByCategoryMap.get(product.category).push(this.createProduct(product))
        }
      )
    });

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
      , data.stars
      , data.description
    )
  }


}
