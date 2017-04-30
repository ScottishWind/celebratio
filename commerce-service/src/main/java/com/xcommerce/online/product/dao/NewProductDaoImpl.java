/**
 * 
 */
package com.xcommerce.online.product.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xcommerce.online.product.model.NewProductBean;
import com.xcommerce.online.product.repository.NewProductRepository;

/**
 * @author gabbu
 *
 */
@Component("newProductDao")
public class NewProductDaoImpl implements ProductDao<NewProductBean> {

	@Autowired
	private NewProductRepository repository;


	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.xcommerce.online.product.dao.ProductDao#insertProduct(com.xcommerce.
	 * online.product.model.NewProductBean)
	 */
	@Override
	public void insertProduct(List<NewProductBean> product) {
		 repository.save(product);
	}
	

	@Override
	public List<NewProductBean> getAllProducts() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public NewProductBean insertProduct(NewProductBean product) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<NewProductBean> getProductByLabel(String label) {
		return repository.findByLabel(label);
	}


	@Override
	public List<NewProductBean> getProductByCategory(String category) {
		return repository.findByCategory(category);
	}


	@Override
	public void deleteByProductId(String id) {
		repository.delete(repository.findByProductID(id));		
	}


	@Override
	public void deleteByCategory(String category) {
		repository.delete(repository.findByCategory(category));	
	}


	@Override
	public void deleteAll() {
		repository.deleteAll();	
	}

}
