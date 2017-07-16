/**
 * 
 */
package com.xcommerce.online.product.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.xcommerce.online.product.model.ProductBean;

public interface ProductRepository extends MongoRepository<ProductBean, String> {
	/**
	 * find Products by Category
	 * 
	 * @param card
	 * @return
	 */
	public List<ProductBean> findByCategory(String category);

	/**
	 * Fine Products by Label
	 * 
	 * @param account
	 * @return
	 */
	public List<ProductBean> findByLabel(String label);

}