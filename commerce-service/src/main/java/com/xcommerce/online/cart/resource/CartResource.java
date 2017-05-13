package com.xcommerce.online.cart.resource;

import java.util.List;

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

import com.xcommerce.online.cart.model.CartItem;
import com.xcommerce.online.product.facade.ProductFacade;
import com.xcommerce.online.product.model.NewProductBean;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/cart")
@CrossOrigin
public class CartResource {
	private final Logger logger = LoggerFactory.getLogger(CartResource.class);

	@Autowired
	private ProductFacade productFacade;

	@ApiOperation(value = "Add/Delete/Edit Item in shopping Cart", nickname = "Add/Delete/Edit Item in shopping Cart")
	@RequestMapping(value = "/modify", method = RequestMethod.POST, consumes = "application/json")
	ResponseEntity<?> addToCart(@RequestBody CartItem item) {
		logger.info(String.format("Add Cart Item %S", item));
		return new ResponseEntity<>("success", HttpStatus.OK);
	}

	@ApiOperation(value = "Empty Cart - Delete All Item from shopping Cart", nickname = "Empty Cart - Delete All Item from shopping Cart")
	@RequestMapping(value = "/clear", method = RequestMethod.POST)
	ResponseEntity<?> deleteAllFromCart() {
		logger.info("Clear all Items in Cart !");
		return new ResponseEntity<>("success", HttpStatus.OK);
	}

	@ApiOperation(value = "View all Items in the shopping Cart", nickname = "View all Items in the shopping Cart")
	@RequestMapping(value = "/view", method = RequestMethod.POST, produces = "application/json")
	List<NewProductBean> getAllItemsFromCart() {
		List<NewProductBean> productLst = productFacade.getProductDetailsByLabel("ganesh");
		return productLst;
	}
}
