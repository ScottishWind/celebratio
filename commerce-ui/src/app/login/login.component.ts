import {Component, OnInit} from '@angular/core';
import {NgbActiveModal} from '@ng-bootstrap/ng-bootstrap';
import {AbstractControl, FormGroup, FormBuilder, Validators} from '@angular/forms';
import {UserService} from '../services/userService';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent {

  complexForm: FormGroup;
  imageLocation = "";

  constructor(public activeModal: NgbActiveModal, private fb: FormBuilder, private userService: UserService) {
    this.complexForm = fb.group({
      'profilePic': [null, null],
      'email': [null, Validators.compose([Validators.required, Validators.email])],
      'password': [null, Validators.compose([Validators.required, Validators.minLength(5)])]
    }, {});
  }


  submitForm(user: any) {
    console.log("User Logging ", user);
    let me = this;
    let res = this.userService.loginUser(user);
    res.then(function (value) {
      console.log("Login Successful");
      me.activeModal.close('Close click');
      me.userService.userChange.next(value);
    });
  }
}

class PasswordValidation {
  static matchPassword(complexForm: FormGroup) {
    if (complexForm) {
      let password = complexForm.controls.password.value;
      let confirmPassword = complexForm.controls.rePassword.value;
      if (password != confirmPassword) {
        console.log('false');
        complexForm.controls.rePassword.setErrors({MatchPassword: true})
      } else {
        console.log('true');
        return null
      }
    }
  }

}
