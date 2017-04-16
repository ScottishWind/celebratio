package com.xcommerce.online.product.resource;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xcommerce.online.product.facade.ProductFacade;
import com.xcommerce.online.product.model.ProductBean;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/product")
public class ProductResource {

	private final Logger logger = LoggerFactory.getLogger(ProductResource.class);

	@Autowired
	private ProductFacade productFacade;

	@ApiOperation(value = "Insert New Product Details", nickname = "Product Insert")
	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	ProductBean createProduct(@RequestBody ProductBean product) {
		logger.info(String.format("New Product add request submitted %S", product));
		ProductBean newProduct = productFacade.createProduct(product);
		return newProduct;
	}

	@ApiOperation(value = "Search Product By Category", nickname = "Category Search")
	@RequestMapping(value = "/search/category", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	List<ProductBean> getProductDetailsBycategory(@RequestBody @NotEmpty String category) {
		logger.info(String.format("Request to fetch Product details for category %S", category));
		List<ProductBean> productLst = productFacade.getProductDetailsByCategory(category);
		return productLst;

	}
	
	@ApiOperation(value = "Search Product By Label", nickname = "Label Search")
	@RequestMapping(value = "/search/label", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	List<ProductBean> getProductDetailsbyLabel(@RequestBody @NotEmpty String label) {
		logger.info(String.format("Request to fetch Product details for label %S", label));
		List<ProductBean> productLst = productFacade.getProductDetailsByLabel(label);
		return productLst;

	}
}

