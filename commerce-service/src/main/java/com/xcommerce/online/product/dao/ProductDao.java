/**
 * 
 */
package com.xcommerce.online.product.dao;

import java.util.List;

import com.xcommerce.online.product.model.Product;

/**
 * @author gabbu
 *
 */
public interface ProductDao<T extends Product> {
	/**
	 * insert new product details in DB
	 * 
	 * @param dto
	 * @return
	 */
	public T insertProduct(T product);

	/**
	 * insert new product details in DB
	 * 
	 * @param dto
	 * @return
	 */
	public void insertProduct(List<T> product);

	/**
	 * Get product details from DB for a product title
	 * 
	 * @param accountNo
	 * @return
	 */
	public List<T> getProductByLabel(String label);

	/**
	 * Get product details from DB for a category
	 * 
	 * @param accountNo
	 * @return
	 */
	public List<T> getProductByCategory(String category);

	/**
	 * Get product details from DB for a category
	 * 
	 * @param accountNo
	 * @return
	 */
	public List<T> getAllProducts();
	
	/**
	 * delete by product id
	 */
	public void deleteByProductId(String id);
	
	/**
	 * delete by category
	 */
	public void deleteByCategory(String category);
	
	/**
	 * delete all products
	 */
	public void deleteAll();


}
