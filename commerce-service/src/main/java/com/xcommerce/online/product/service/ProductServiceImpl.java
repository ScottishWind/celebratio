/**
 * 
 */
package com.xcommerce.online.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xcommerce.online.product.dao.ProductDao;
import com.xcommerce.online.product.helper.ProductServiceHelper;
import com.xcommerce.online.product.model.ProductBean;

@Component
public class ProductServiceImpl implements ProductService<ProductBean> {

	@Autowired
	private ProductServiceHelper productHelper;

	@Autowired
	private ProductDao<ProductBean> productdao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.xcommerce.online.product.service.ProductService#createNewProduct(com.
	 * xcommerce.online.product.model.ProductBean)
	 */
	@Override
	public ProductBean createProduct(ProductBean product) {
		product = productHelper.createProductObject(product);
		return productdao.insertProduct(product);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xcommerce.online.product.service.ProductService#
	 * searchProductByCategory(java.lang.String)
	 */
	@Override
	public List<ProductBean> searchByCategory(String category) {
		// TODO Auto-generated method stub
		return productdao.getProductByCategory(category);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.xcommerce.online.product.service.ProductService#searchProductByLabel(
	 * java.lang.String)
	 */
	@Override
	public List<ProductBean> searchByLabel(String label) {
		// TODO Auto-generated method stub
		return productdao.getProductByLabel(label);
	}

	@Override
	public void createProduct(List<ProductBean> product) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<ProductBean> retrieveAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(String productid) {
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
