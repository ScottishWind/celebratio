import { Component } from '@angular/core';
/*import {CartService} from '../services/cartService';*/
import {Product} from '../products/model/product';
import {Subscription} from 'rxjs/Subscription';
import {CartService} from '../services/cartService';
import {Router} from '@angular/router';
import {FormGroup, FormBuilder, Validators} from '@angular/forms';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent {
	sum = 0;
  productList: Product[] = new Array<Product>();
  complexForm: FormGroup;
  cities: String[] = new Array<String>();
  states: String[] = new Array<String>();
  countries: String[] = new Array<String>();
  

   constructor(private cartService: CartService, private router: Router, private fb: FormBuilder) {
    this.cartService.getProductList().subscribe(productList => {
    	console.log(productList);
      this.productList = productList;
    });

     this.complexForm = fb.group({
      'firstName': [null, Validators.required],
      'lastName': [null, Validators.required],
      'email': [null, Validators.compose([Validators.required, Validators.email])],
      'phoneNumber': [null],
      'password': [null, Validators.compose([Validators.required, Validators.minLength(5), Validators.maxLength(10)])],
      'firstLine': [null, Validators.required],
      'secondLine': [null],
      'thirdLine': [null],
      'landmark': [null],
      'postcode': [null, Validators.required],
      'city': [null, Validators.required],
      'state': [null, Validators.required],
      'country': [null, Validators.required]
    });
    this.populateCities();
    this.populateStates();
    this.populateCountry();
  }


  

 openAccordian(formPanel,ele){
    document.getElementById(ele).classList.toggle("active");
    let panel:any = document.getElementById(formPanel);
    if (panel.style.maxHeight){
      panel.style.maxHeight = null;
    } else {
      panel.style.maxHeight = panel.scrollHeight + "px";
    } 
  }

   populateCities() {
    this.cities.push("Kolkata", "Mumbai", "Delhi", "Bangalore");
  }

  populateStates() {
    this.states.push("West Bengal", "Maharashtra", "Karnataka", "Uttar Pradesh");
  }

  populateCountry() {
    this.countries.push("India");
  }

	submitForm(value: any) {
	   this.openAccordian('orderPanel','orderSummary')
	  }

}


