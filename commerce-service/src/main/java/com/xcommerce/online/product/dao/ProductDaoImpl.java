/**
 * 
 */
package com.xcommerce.online.product.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.xcommerce.online.product.model.ProductBean;
import com.xcommerce.online.product.repository.ProductRepository;

/**
 * @author gabbu
 *
 */
@Component("productDao")
public class ProductDaoImpl implements ProductDao<ProductBean> {

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

	@Override
	public void insertProduct(List<ProductBean> product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ProductBean> getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteByProductId(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteByCategory(String category) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}


}
