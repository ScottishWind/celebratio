package com.xcommerce.online.user.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xcommerce.online.user.model.User;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin
public class UserResource {

	private final Logger logger = LoggerFactory.getLogger(UserResource.class);

	@ApiOperation(value = "Register a new User in the site", nickname = "Register new User")
	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = "application/json")
	ResponseEntity<?> createUser(@RequestBody User user) {
		logger.info(String.format("New User Creation request %S", user));
		return new ResponseEntity<>("success", HttpStatus.OK);
	}

	@ApiOperation(value = "Modify details of a registered User", nickname = "Edit details of an existing User")
	@RequestMapping(value = "/modify", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	User modifyUser(@RequestBody User user) {
		logger.info(String.format("Modify Existing User %S", user));
		return new User();
	}

	@ApiOperation(value = "Permanently Delete User profile", nickname = "Permanently Delete User profile")
	@RequestMapping(value = "/delete", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	ResponseEntity<?> deleteUser() {
		logger.info("Completely delete user from website!");
		return new ResponseEntity<>("success", HttpStatus.OK);
	}

	@ApiOperation(value = "Temporarily Deactivate User profile", nickname = "Temporarily Deactivate User profile")
	@RequestMapping(value = "/deactivate", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	ResponseEntity<?> deactivateUser() {
		logger.info("Temporarily deactivate user from website!");
		return new ResponseEntity<>("success", HttpStatus.OK);
	}

	@ApiOperation(value = "View User Details", nickname = "View User Details")
	@RequestMapping(value = "/view", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	User getDetails() {
		logger.info("View user Details!");
		return new User();
	}

}
