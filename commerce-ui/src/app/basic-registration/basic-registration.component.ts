import {Component, OnInit} from '@angular/core';
import {NgbActiveModal} from '@ng-bootstrap/ng-bootstrap';
import {AbstractControl, FormGroup, FormBuilder, Validators} from '@angular/forms';
import {UserService} from '../services/userService';

@Component({
  selector: 'app-basic-registration',
  templateUrl: './basic-registration.component.html',
  styleUrls: ['./basic-registration.component.css'],
  providers: [UserService]
})
export class BasicRegistrationComponent {

  complexForm: FormGroup;
  imageLocation = "";

  constructor(public activeModal: NgbActiveModal, private fb: FormBuilder, private userService: UserService) {
    this.complexForm = fb.group({
      'profilePic': [null, null],
      'email': [null, Validators.compose([Validators.required, Validators.email])],
      'password': [null, Validators.compose([Validators.required, Validators.minLength(5)])],
      'rePassword': [null, Validators.compose([Validators.required])]
    }, {
      validator: PasswordValidation.matchPassword
    });
  }


  submitForm(user: any) {
    console.log("Registering ", user);
    let res = this.userService.registerUser(user);
    res.then(function (value) {
      if (value == "success") {
        console.log("Registration Successful");
        return "succes";
      }
      else {
        console.log("Registration Failed");
        return "failed";
      }
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
