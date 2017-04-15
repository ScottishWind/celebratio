/**
 * 
 */
package com.xcommerce.online.product.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.xcommerce.online.product.model.ProductBean;
import com.xcommerce.online.product.repository.ProductRepository;

/**
 * @author gabbu
 *
 */
@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private ProductRepository repository;

	@Autowired
	private MongoTemplate mongoTemplate;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.xcommerce.online.product.dao.ProductDao#insertProduct(com.xcommerce.
	 * online.product.model.ProductBean)
	 */
	@Override
	public ProductBean insertProduct(final ProductBean product) {
		//MongoOperations mongoOperation = (MongoOperations)mongoTemplate;
		//mongoTemplate.save(product);
		return repository.save(product);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.xcommerce.online.product.dao.ProductDao#getProductByTitle(java.lang.
	 * String)
	 */
	@Override
	public List<ProductBean> getProductByLabel(String label) {
		return repository.findByLabel(label);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.xcommerce.online.product.dao.ProductDao#getProductByCategory(java.
	 * lang.String)
	 */
	@Override
	public List<ProductBean> getProductByCategory(String category) {
		// TODO Auto-generated method stub
		return repository.findByCategory(category);
	}

}
