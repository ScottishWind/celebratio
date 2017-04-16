/**
 * 
 */
package com.xcommerce.online.product.service;

import java.util.List;

import com.xcommerce.online.product.model.ProductBean;

/**
 * @author gabbu
 *
 */
public interface ProductService {

	/**
	 * create new product
	 * 
	 * @param product
	 * @return
	 */
	public ProductBean createNewProduct(ProductBean product);

	/**
	 * product search by category
	 * 
	 * @param category
	 * @return
	 */
	public List<ProductBean> searchProductByCategory(String category);
	
	/**
	 * product search by label
	 * 
	 * @param category
	 * @return
	 */
	public List<ProductBean> searchProductByLabel(String label);
}
