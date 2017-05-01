/**
 * 
 */
package com.xcommerce.online.product.model;

import java.util.List;
import java.util.Random;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product")
public class NewProductBean extends Product {
	
	private List<String> category;
	private String subCategory;
	private List<String> images;
	private String price;
	private String priceAfterDiscount;
	private String discount;
	private String discountLabel;
	private String priceLabel;
	private String name;
	private String title;
	private String description;
	private String availableQuantity;
	private List<String> label;
	private String stars;

	/**
	 * @return the category
	 */
	public List<String> getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(List<String> category) {
		this.category = category;
	}

	/**
	 * @return the subCategory
	 */
	public String getSubCategory() {
		return subCategory;
	}

	/**
	 * @param subCategory
	 *            the subCategory to set
	 */
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	/**
	 * @return the images
	 */
	public List<String> getImages() {
		return images;
	}

	/**
	 * @param images
	 *            the images to set
	 */
	public void setImages(List<String> images) {
		this.images = images;
	}

	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}

	/**
	 * @return the priceAfterDiscount
	 */
	public String getPriceAfterDiscount() {
		return priceAfterDiscount;
	}

	/**
	 * @param priceAfterDiscount
	 *            the priceAfterDiscount to set
	 */
	public void setPriceAfterDiscount(String priceAfterDiscount) {
		this.priceAfterDiscount = priceAfterDiscount;
	}

	/**
	 * @return the discount
	 */
	public String getDiscount() {
		return discount;
	}

	/**
	 * @param discount
	 *            the discount to set
	 */
	public void setDiscount(String discount) {
		this.discount = discount;
	}

	/**
	 * @return the discountLabel
	 */
	public String getDiscountLabel() {
		return discountLabel;
	}

	/**
	 * @param discountLabel
	 *            the discountLabel to set
	 */
	public void setDiscountLabel(String discountLabel) {
		this.discountLabel = discountLabel;
	}

	/**
	 * @return the priceLabel
	 */
	public String getPriceLabel() {
		return priceLabel;
	}

	/**
	 * @param priceLabel
	 *            the priceLabel to set
	 */
	public void setPriceLabel(String priceLabel) {
		this.priceLabel = priceLabel;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the availableQuantity
	 */
	public String getAvailableQuantity() {
		return availableQuantity;
	}

	/**
	 * @param availableQuantity
	 *            the availableQuantity to set
	 */
	public void setAvailableQuantity(String availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	/**
	 * @return the label
	 */
	public List<String> getLabel() {
		return label;
	}

	/**
	 * @param label
	 *            the label to set
	 */
	public void setLabel(List<String> label) {
		this.label = label;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "NewProductBean [productID=" + productID + ", category=" + category + ", subCategory=" + subCategory
				+ ", images=" + images + ", price=" + price + ", priceAfterDiscount=" + priceAfterDiscount
				+ ", discount=" + discount + ", discountLabel=" + discountLabel + ", priceLabel=" + priceLabel
				+ ", name=" + name + ", title=" + title + ", description=" + description + ", availableQuantity="
				+ availableQuantity + ", label=" + label + "]";
	}

	/**
	 * @return the stars
	 */
	public String getStars() {
		Random rand = new Random();
		int  n = rand.nextInt(5) + 1;
		return String.valueOf(n);
	}

	/**
	 * @param stars the stars to set
	 */
	public void setStars(String stars) {
		this.stars = stars;
	}

}
