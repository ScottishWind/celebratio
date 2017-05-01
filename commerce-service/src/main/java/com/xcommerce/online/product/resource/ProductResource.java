package com.xcommerce.online.product.resource;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xcommerce.online.product.facade.ProductFacade;
import com.xcommerce.online.product.model.NewProductBean;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/product")
@CrossOrigin
public class ProductResource {

	private final Logger logger = LoggerFactory.getLogger(ProductResource.class);

	@Autowired
	private ProductFacade productFacade;

	@ApiOperation(value = "Inserts new Products - Accepts list of products", nickname = "New Product Insert")
	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = "application/json")
	ResponseEntity<?> createNewProduct(@RequestBody List<NewProductBean> product) {
		logger.info(String.format("New Product add request submitted %S", product));
		productFacade.createNewProduct(product);
		return new ResponseEntity<>("success", HttpStatus.OK);
	}

	@ApiOperation(value = "Returns all Products that matches the Product Category", nickname = "Category Search")
	@RequestMapping(value = "/search/category", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	List<NewProductBean> getProductDetailsBycategory(@RequestBody @NotEmpty String category) {
		logger.info(String.format("Request to fetch Product details for category %S", category));
		List<NewProductBean> productLst = productFacade.getProductDetailsByCategory(category);
		return productLst;

	}

	@ApiOperation(value = "Returns all Products that matches the Label", nickname = "Label Search")
	@RequestMapping(value = "/search/label", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	List<NewProductBean> getProductDetailsbyLabel(@RequestBody @NotEmpty String label) {
		logger.info(String.format("Request to fetch Product details for label %S", label));
		List<NewProductBean> productLst = productFacade.getProductDetailsByLabel(label);
		return productLst;

	}

	@ApiOperation(value = "HomeScreen Products - **Currently returns all products**", nickname = "Category Search")
	@RequestMapping(value = "/homescreen", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	List<NewProductBean> getAllProductHome() {
		logger.info(String.format("Request to fetch Product details for homescreen"));
		List<NewProductBean> productLst = productFacade.getHomeScreenProducts();
		return productLst;

	}

	@ApiOperation(value = "Deletes a single Product that matches the input Product ID", nickname = "Delete Product")
	@RequestMapping(value = "/delete/id", method = RequestMethod.POST, consumes = "application/json")
	ResponseEntity<?> deleteByProductId(@RequestBody @NotEmpty String productId) {
		logger.info(String.format("Request to delete Product by product ID %S", productId));
		productFacade.deleteByProductId(productId);
		return (new ResponseEntity<>("success", HttpStatus.OK));
	}

	@ApiOperation(value = "Deletes All Products that belong to the input Category", nickname = "Delete Product")
	@RequestMapping(value = "/delete/category", method = RequestMethod.POST, consumes = "application/json")
	ResponseEntity<?> deleteByCategory(@RequestBody @NotEmpty String category) {
		logger.info(String.format("Request to delete Product by category %S", category));
		productFacade.deleteByCategory(category);
		return (new ResponseEntity<>("success", HttpStatus.OK));
	}

	@ApiOperation(value = "Deletes entire Product list from Backend - **Risky Operation**", nickname = "Delete All Products")
	@RequestMapping(value = "/delete/all", method = RequestMethod.POST, consumes = "application/json")
	ResponseEntity<?> deleteAll() {
		logger.info("Request to delete All Products from backend Database");
		productFacade.deleteAll();
		return (new ResponseEntity<>("success", HttpStatus.OK));
	}
}
