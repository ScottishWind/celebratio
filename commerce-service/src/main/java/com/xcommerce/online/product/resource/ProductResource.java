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
import com.xcommerce.online.product.model.NewProductBean;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/product")
public class ProductResource {

	private final Logger logger = LoggerFactory.getLogger(ProductResource.class);

	@Autowired
	private ProductFacade productFacade;

	/**
	 * @ApiOperation(value = "Insert Product Details - Old version", nickname =
	 *                     "Product Insert")
	 * @RequestMapping(value = "/create", method = RequestMethod.POST, consumes
	 *                       = "application/json", produces =
	 *                       "application/json") ProductBean
	 *                       createProduct(@RequestBody ProductBean product) {
	 *                       logger.info(String.format("New Product add request
	 *                       submitted %S", product)); ProductBean newProduct =
	 *                       productFacade.createProduct(product); return
	 *                       newProduct; }
	 **/

	@ApiOperation(value = "Insert Product Details - Accepts list of items", nickname = "New Product Insert")
	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	void createNewProduct(@RequestBody List<NewProductBean> product) {
		logger.info(String.format("New Product add request submitted %S", product));
		productFacade.createNewProduct(product);
	}

	@ApiOperation(value = "Search Product By Category", nickname = "Category Search")
	@RequestMapping(value = "/search/category", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	List<NewProductBean> getProductDetailsBycategory(@RequestBody @NotEmpty String category) {
		logger.info(String.format("Request to fetch Product details for category %S", category));
		List<NewProductBean> productLst = productFacade.getProductDetailsByCategory(category);
		return productLst;

	}

	@ApiOperation(value = "Search Product By Label", nickname = "Label Search")
	@RequestMapping(value = "/search/label", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	List<NewProductBean> getProductDetailsbyLabel(@RequestBody @NotEmpty String label) {
		logger.info(String.format("Request to fetch Product details for label %S", label));
		List<NewProductBean> productLst = productFacade.getProductDetailsByLabel(label);
		return productLst;

	}

	@ApiOperation(value = "Homescreen products", nickname = "Category Search")
	@RequestMapping(value = "/home", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	List<NewProductBean> getAllProductHome() {
		logger.info(String.format("Request to fetch Product details for homescreen"));
		List<NewProductBean> productLst = productFacade.getHomeScreenProducts();
		return productLst;

	}
	
	@ApiOperation(value = "Delete Product by Product ID", nickname = "Delete Product")
	@RequestMapping(value = "/delete/id", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	void deleteByProductId(@RequestBody @NotEmpty String productId) {
		logger.info(String.format("Request to delete Product by product ID %S", productId));
		productFacade.deleteByProductId(productId);
	}
	
	@ApiOperation(value = "Delete All Products in the Category", nickname = "Delete Product")
	@RequestMapping(value = "/delete/category", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	void deleteByCategory(@RequestBody @NotEmpty String category) {
		logger.info(String.format("Request to delete Product by category %S", category));
		productFacade.deleteByCategory(category);
	}
	
	@ApiOperation(value = "Delete All Product - **Risky Operation - Emties entire Database**", nickname = "Delete All Products")
	@RequestMapping(value = "/delete/all", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	void deleteAll() {
		logger.info("Request to delete All Products from backend Database");
		productFacade.deleteAll();
	}
}
