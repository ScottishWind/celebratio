/**
 * 
 */
package com.xcommerce.online.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xcommerce.online.product.dao.ProductDao;
import com.xcommerce.online.product.model.NewProductBean;

@Component
public class NewProductServiceImpl implements ProductService<NewProductBean> {

	@Autowired
	private ProductDao<NewProductBean> productdao;

	@Override
	public void createProduct(List<NewProductBean> product) {
		productdao.insertProduct(product);
	}

	@Override
	public List<NewProductBean> retrieveAllProducts() {
		// TODO Auto-generated method stub
		return productdao.getAllProducts();
	}

	@Override
	public NewProductBean createProduct(NewProductBean product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NewProductBean> searchByCategory(String category) {
		return productdao.getProductByCategory(category);
	}

	@Override
	public List<NewProductBean> searchByLabel(String label) {
		return productdao.getProductByLabel(label);
	}

	@Override
	public void deleteById(String productid) {
		productdao.deleteByProductId(productid);	
	}

	@Override
	public void deleteByCategory(String category) {
		productdao.deleteByCategory(category);	
	}

	@Override
	public void deleteAll() {
		productdao.deleteAll();	
	}

}
