import {Component, ViewChild, AfterViewInit} from '@angular/core';
import {Product} from './products/model/product';
import {HeaderComponent} from './header/header.component';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements AfterViewInit {

  @ViewChild('header') private headerComponent: HeaderComponent;

  ngAfterViewInit() {
    console.log('on after view init', this.headerComponent);
    // this returns null
  }

  proceedCartAddEvent(product: Product) {
    this.headerComponent.addToCart(product)
  }

}
