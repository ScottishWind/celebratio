export class Product {
  category: String;
  subCategory: String;
  image: String;
  discount: Number;
  actualPrice: Number;
  discountedPrice: Number;
  label: String;
  name: String
  title: String
  description: String;


  constructor(category: String, subCategory: String, image: String, discount: Number, actualPrice: Number, discountedPrice: Number, label: String, name: String, title: String, description: String) {
    this.category = category;
    this.subCategory = subCategory;
    this.image = image;
    this.discount = discount;
    this.actualPrice = actualPrice;
    this.discountedPrice = discountedPrice;
    this.label = label;
    this.name = name;
    this.title = title;
    this.description = description;
  }
}
