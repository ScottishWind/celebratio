package com.xcommerce.online.product.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xcommerce.online.product.model.NewProductBean;
import com.xcommerce.online.product.model.ProductBean;
import com.xcommerce.online.product.service.ProductService;

@Component
public class ProductFacade {

	@Autowired
	private ProductService<ProductBean> productService;

	@Autowired
	private ProductService<NewProductBean> newProductService;

	/**
	 * method to create single bean object
	 * 
	 * @param product
	 * @return
	 */
	public ProductBean createProduct(ProductBean product) {
		return productService.createProduct(product);
	}

	/**
	 * overloaded method to create single new bean object
	 * 
	 * @param product
	 * @return
	 */
	public NewProductBean createProduct(NewProductBean product) {
		return newProductService.createProduct(product);
	}

	/**
	 * serach by category
	 * 
	 * @param category
	 * @return
	 */
	public List<NewProductBean> getProductDetailsByCategory(String category) {
		return newProductService.searchByCategory(category);
	}

	/**
	 * search by label
	 * 
	 * @param label
	 * @return
	 */
	public List<NewProductBean> getProductDetailsByLabel(String label) {
		return newProductService.searchByLabel(label);
	}

	/**
	 * insert list of new products
	 * 
	 * @param product
	 */
	public void createNewProduct(List<NewProductBean> product) {
		newProductService.createProduct(product);
	}

	/**
	 * get all products for home screen
	 * 
	 * @return
	 */
	public List<NewProductBean> getHomeScreenProducts() {
		return newProductService.retrieveAllProducts();
	}
	
	/**
	 * delete product by category
	 * 
	 * @return
	 */
	public void deleteByCategory(String category) {
		newProductService.deleteByCategory(category);
	}
	
	/**
	 * delete product by id
	 * 
	 * @return
	 */
	public void deleteByProductId(String productId) {
		newProductService.deleteById(productId);
	}
	
	/**
	 * delete product by id
	 * 
	 * @return
	 */
	public void deleteAll() {
		newProductService.deleteAll();
	}

}
