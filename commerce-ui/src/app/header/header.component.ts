import {Component, NgModule, ViewChild} from '@angular/core';
import {CartComponent} from '../cart/cart.component';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {BasicRegistrationComponent} from '../basic-registration/basic-registration.component'
import {LoginComponent} from '../login/login.component'
import {UserComponent} from '../user/user.component'
import {UserService} from '../services/userService';
import {User} from '../user/model/user';

@Component({
  selector: 'app-headercomponent',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
})
export class HeaderComponent {

  user: User;

  constructor(private modalService: NgbModal, private userService: UserService) {
    this.user = this.userService.user;
    this.userService.userChange.subscribe(value => {
      this.user = value;
    });
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
