import {Component, OnInit} from '@angular/core';
import {NgbActiveModal} from '@ng-bootstrap/ng-bootstrap';
import {FormGroup, FormBuilder, Validators} from '@angular/forms';


@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent {

  complexForm: FormGroup;
  cities: String[] = new Array<String>();
  states: String[] = new Array<String>();
  countries: String[] = new Array<String>();

  constructor(public activeModal: NgbActiveModal, private fb: FormBuilder) {
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
    console.log(value);
  }

}
