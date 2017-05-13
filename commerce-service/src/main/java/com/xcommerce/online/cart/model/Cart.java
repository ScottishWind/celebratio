package com.xcommerce.online.cart.model;

import java.util.List;

import com.xcommerce.online.product.model.Product;

public class Cart {
	String cartID;
	List<Product> products;

	/**
	 * @return the cartID
	 */
	public String getCartID() {
		return cartID;
	}

	/**
	 * @param cartID
	 *            the cartID to set
	 */
	public void setCartID(String cartID) {
		this.cartID = cartID;
	}

	/**
	 * @return the products
	 */
	public List<Product> getProducts() {
		return products;
	}

	/**
	 * @param products
	 *            the products to set
	 */
	public void setProducts(List<Product> products) {
		this.products = products;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Cart [cartID=" + cartID + ", products=" + products + "]";
	}

}