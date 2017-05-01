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


}
