import {Address} from "./address"

export class User {
  userId: String;
  firstName: String;
  lastName: String;
  phoneNumber: String;
  email: String;
  profilePicture: String;
  address: Address;
  billingAddress: Address[];
  password : String;

  constructor(userId: String, firstName: String, lastName: String, phoneNumber: String, email: String, profilePicture: String, address: Address, billingAddress: Address[], password: String) {
    this.userId = userId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.profilePicture = profilePicture;
    this.address = address;
    this.billingAddress = billingAddress;
    this.password = password;
  }
}
