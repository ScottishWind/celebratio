import {Component, OnInit, NgModule, ViewChild} from '@angular/core';
import {CartComponent} from '../cart/cart.component';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {BasicRegistrationComponent} from '../basic-registration/basic-registration.component'
import {LoginComponent} from '../login/login.component'
import {UserComponent} from '../user/user.component'

@Component({
  selector: 'app-headercomponent',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private modalService: NgbModal) {

  }

  ngOnInit() {
  }

  openRegistration() {
    this.modalService.open(BasicRegistrationComponent);
  }

  openLogin() {
    this.modalService.open(LoginComponent);
  }

  openUserProfile() {
    this.modalService.open(UserComponent);
  }
}
