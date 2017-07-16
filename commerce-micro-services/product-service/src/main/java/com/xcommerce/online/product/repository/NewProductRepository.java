/**
 * 
 */
package com.xcommerce.online.product.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.xcommerce.online.product.model.NewProductBean;

public interface NewProductRepository extends MongoRepository<NewProductBean, String> {
	/**
	 * find Products by Category
	 * 
	 * @param card
	 * @return
	 */
	public List<NewProductBean> findByCategory(String category);

	/**
	 * Fine Products by Label
	 * 
	 * @param account
	 * @return
	 */
	public List<NewProductBean> findByLabel(String label);
	
	/**
	 * find by product id
	 * @param id
	 * @return
	 */
	public NewProductBean findByProductID(String id);
}