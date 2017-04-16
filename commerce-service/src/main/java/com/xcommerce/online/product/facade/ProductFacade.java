/**
 * 
 */
package com.xcommerce.online.product.facade;

import java.util.List;

import com.xcommerce.online.product.model.ProductBean;

/**
 * @author gabbu
 *
 */
public interface ProductFacade {

	/**
	 * create new product
	 * @param product
	 * @return
	 */
	public ProductBean createProduct(ProductBean product);
	
	/**
	 * product search by category
	 * @param category
	 * @return
	 */
	public List<ProductBean> getProductDetailsByCategory(String category);
	
	/**
	 * product search by label
	 * @param category
	 * @return
	 */
	public List<ProductBean> getProductDetailsByLabel(String label);
}
