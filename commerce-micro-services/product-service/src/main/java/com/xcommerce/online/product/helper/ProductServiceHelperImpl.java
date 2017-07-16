/**
 * 
 */
package com.xcommerce.online.product.helper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.xcommerce.online.product.model.ProductBean;

/**
 * @author gabbu
 *
 */
@Component
public class ProductServiceHelperImpl implements ProductServiceHelper {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xcommerce.online.product.helper.ProductServiceHelper#
	 * createProductObject(com.xcommerce.online.product.model.ProductBean)
	 */
	@Override
	public ProductBean createProductObject(ProductBean product) {
		List<String> label = new ArrayList<String>();
		label.addAll(product.getCategory());
		label.addAll(product.getAttributes().keySet());
		label.addAll(product.getAttributes().values());
		product.setLabel(label);
		return product;
	}

}
