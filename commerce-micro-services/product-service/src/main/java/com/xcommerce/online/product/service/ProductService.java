/**
 * 
 */
package com.xcommerce.online.product.service;

import java.util.List;

import com.xcommerce.online.product.model.Product;

public interface ProductService<T extends Product> {

	/**
	 * create new product
	 * 
	 * @param product
	 * @return
	 */
	public T createProduct(T product);

	/**
	 * create new product
	 * 
	 * @param product
	 * @return
	 */
	public void createProduct(List<T> product);

	/**
	 * product search by category
	 * 
	 * @param category
	 * @return
	 */
	public List<T> searchByCategory(String category);

	/**
	 * product search by label
	 * 
	 * @param category
	 * @return
	 */
	public List<T> searchByLabel(String label);

	/**
	 * retrieve all products in db
	 * @return
	 */
	public List<T> retrieveAllProducts();
	
	/**
	 * delete by product id
	 * @param productid
	 */
	public void deleteById(String productid);
	
	/**
	 * delete by category name
	 * @param category
	 */
	public void deleteByCategory(String category);
	
	/**
	 * delete all products
	 * @param category
	 */
	public void deleteAll();

}
