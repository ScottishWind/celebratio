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

/**
 * @author gabbu
 *
 */
@Component
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductServiceHelper productHelper;
	
	@Autowired
	private ProductDao productdao;
	
	/* (non-Javadoc)
	 * @see com.xcommerce.online.product.service.ProductService#createNewProduct(com.xcommerce.online.product.model.ProductBean)
	 */
	@Override
	public ProductBean createNewProduct(ProductBean product) {
		product = productHelper.createProductObject(product);
		return productdao.insertProduct(product);
	}

	/* (non-Javadoc)
	 * @see com.xcommerce.online.product.service.ProductService#searchProductByCategory(java.lang.String)
	 */
	@Override
	public List<ProductBean> searchProductByCategory(String category) {
		// TODO Auto-generated method stub
		return productdao.getProductByCategory(category);
	}

	/* (non-Javadoc)
	 * @see com.xcommerce.online.product.service.ProductService#searchProductByLabel(java.lang.String)
	 */
	@Override
	public List<ProductBean> searchProductByLabel(String label) {
		// TODO Auto-generated method stub
		return productdao.getProductByLabel(label);
	}

}
