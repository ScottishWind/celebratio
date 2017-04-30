package com.xcommerce.online.product.model;

import org.springframework.data.annotation.Id;

/**
 * Every product type should extend this
 * @author gabbu
 *
 */
public abstract class Product {

	@Id
	protected String productID;

	/**
	 * @return the productID
	 */
	public String getProductID() {
		return productID;
	}

	/**
	 * @param productID
	 *            the productID to set
	 */
	public void setProductID(String productID) {
		this.productID = productID;
	}

}
