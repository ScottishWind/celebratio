package com.xcommerce.online.product.model;

import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product")
public class ProductBean extends Product {

	private String name;
	private String title;
	private String price;
	private String image;
	private String description;
	private List<String> category;
	private Map<String, String> attributes;
	private List<String> label;

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
	 * @return the attributes
	 */
	public Map<String, String> getAttributes() {
		return attributes;
	}

	/**
	 * @param attributes
	 *            the attributes to set
	 */
	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}

	/**
	 * @return the labels
	 */
	public List<String> getLabel() {
		return label;
	}

	/**
	 * @param labels
	 *            the labels to set
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
		return "ProductBean [productID=" + productID + ", title=" + title + ", price=" + price + ", description=" + description + ", category=" + category + ", attributes="
				+ attributes + ", label=" + label + "]";
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}

}
