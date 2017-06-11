import {Address} from "./address"

export class User {
  profilePicture: String;
  email: String;
  password: String;
  firstName: String;
  lastName: String;
  mobileNumber: String;
  address: Address;
  billingAddress: Address[];
  UserType: String;

  constructor(profilePicture: String, email: String, password: String, UserType: String) {
    this.profilePicture = profilePicture;
    this.email = email;
    this.password = password;
    this.UserType = UserType;
  }
}
