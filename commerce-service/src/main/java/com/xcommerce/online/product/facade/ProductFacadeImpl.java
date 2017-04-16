package com.xcommerce.online.product.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xcommerce.online.product.model.ProductBean;
import com.xcommerce.online.product.service.ProductService;

@Component
public class ProductFacadeImpl implements ProductFacade {

	@Autowired
	private ProductService productService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xcommerce.online.product.facade.ProductFacade#createProduct(com.
	 * xcommerce.online.product.model.ProductBean)
	 */
	@Override
	public ProductBean createProduct(ProductBean product) {
		return productService.createNewProduct(product);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.xcommerce.online.product.facade.ProductFacade#getProductDetails(java.
	 * lang.String)
	 */
	@Override
	public List<ProductBean> getProductDetailsByCategory(String category) {
		return productService.searchProductByCategory(category);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xcommerce.online.product.facade.ProductFacade#
	 * getProductDetailsByLabel(java.lang.String)
	 */
	@Override
	public List<ProductBean> getProductDetailsByLabel(String label) {
		return productService.searchProductByLabel(label);
	}

}
