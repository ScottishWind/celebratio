/**
 * 
 */
package com.xcommerce.online.product.dao;

import java.util.List;

import com.xcommerce.online.product.model.ProductBean;

/**
 * @author gabbu
 *
 */
public interface ProductDao {
	/**
	 * insert new product details in DB
	 * 
	 * @param dto
	 * @return
	 */
	public ProductBean insertProduct(ProductBean product);

	/**
	 * Get product details from DB for a product title
	 * 
	 * @param accountNo
	 * @return
	 */
	public List<ProductBean> getProductByLabel(String title);

	/**
	 * Get product details from DB for a category
	 * 
	 * @param accountNo
	 * @return
	 */
	public List<ProductBean> getProductByCategory(String category);

}
