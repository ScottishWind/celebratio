export class Product {
  productID: String;
  category: Array<String>;
  subCategory: String;
  images: Array<String>;
  price: Number;
  priceAfterDiscount: Number;
  discount: Number;
  discountLabel: String;
  priceLabel: String;
  name: String;
  title: String;
  description: String;
  availableQuantity: Number;
  stars: Number;
  label: Array<String>;


  constructor(productID: String, category: Array<String>, subCategory: String, images: Array<String>, price: Number, priceAfterDiscount: Number, discount: Number, discountLabel: String, priceLabel: String, name: String, title: String, description: String, availableQuantity: Number, stars: Number, label: Array<String>) {
    this.productID = productID;
    this.category = category;
    this.subCategory = subCategory;
    this.images = images;
    this.price = price;
    this.priceAfterDiscount = priceAfterDiscount;
    this.discount = discount;
    this.discountLabel = discountLabel;
    this.priceLabel = priceLabel;
    this.name = name;
    this.title = title;
    this.description = description;
    this.availableQuantity = availableQuantity;
    this.stars = stars;
    this.label = label;
  }

  getActualPrice(): Number {
    if (this.discount > 0) {
      return this.priceAfterDiscount
    }
    else {
      return this.price;
    }
  }
}
