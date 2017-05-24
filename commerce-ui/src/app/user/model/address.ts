export class Address {
  firstLine: String;
  secondLine: String;
  thirdLine: String;
  postcode: String;
  city: String;
  state: String;
  country: String;
  landmark: String;


  constructor(firstLine: String, secondLine: String, thirdLine: String, postcode: String, city: String, state: String, country: String, landmark: String) {
    this.firstLine = firstLine;
    this.secondLine = secondLine;
    this.thirdLine = thirdLine;
    this.postcode = postcode;
    this.city = city;
    this.state = state;
    this.country = country;
    this.landmark = landmark;
  }
}
