/**
 * 
 */
package com.xcommerce.online.product.helper;

import com.xcommerce.online.product.model.ProductBean;

/**
 * @author gabbu
 *
 */
public interface ProductServiceHelper {

	/**
	 * create product object to persist in DB
	 * @param product
	 * @return
	 */
	public ProductBean createProductObject(ProductBean product);
}
