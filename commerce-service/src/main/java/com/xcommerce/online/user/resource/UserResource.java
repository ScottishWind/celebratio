package com.xcommerce.online.user.resource;

import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xcommerce.online.user.facade.UserFacade;
import com.xcommerce.online.user.model.User;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin
public class UserResource {

	@Autowired
	private UserFacade<User> facade;

	private final Logger logger = LoggerFactory.getLogger(UserResource.class);

	@ApiOperation(value = "Register a new User in the site", nickname = "Register new User")
	@RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/json")
	ResponseEntity<?> createUser(@RequestBody User user) {
		logger.info(String.format("New User Creation request %S", user));
		facade.createUser(user);
		return new ResponseEntity<>("success", HttpStatus.OK);
	}

	@ApiOperation(value = "User login", nickname = "Register new User")
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json")
	ResponseEntity<?> login(@RequestBody User user) {
		logger.info(String.format("User login request %S", user));
		return new ResponseEntity<>("success", HttpStatus.OK);
	}

	@ApiOperation(value = "Modify User Profile", nickname = "Edit details of an existing User")
	@RequestMapping(value = "/secure/update", method = RequestMethod.POST, consumes = "application/json")
	ResponseEntity<?> modifyUser(@RequestBody User user) {
		logger.info(String.format("Modify Existing User %S", user));
		facade.modifyUser(user);
		return new ResponseEntity<>("success", HttpStatus.OK);
	}

	@ApiOperation(value = "Permanently Delete User profile", nickname = "Permanently Delete User profile")
	@RequestMapping(value = "/secure/delete", method = RequestMethod.GET)
	ResponseEntity<?> deleteUser() {
		logger.info("Completely delete user from website!");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userID = (String) auth.getPrincipal();
		facade.deleteUser(userID);
		return new ResponseEntity<>("success", HttpStatus.OK);
	}

	@ApiOperation(value = "Permanently Delete All Users **Risky Operation**", nickname = "Permanently Delete User profile")
	@RequestMapping(value = "/delete/all", method = RequestMethod.GET)
	ResponseEntity<?> deleteAllUser() {
		logger.info("Completely delete user from website!");
		facade.deleteAllUser();
		return new ResponseEntity<>("success", HttpStatus.OK);
	}

	@ApiOperation(value = "Temporarily Deactivate User profile", nickname = "Temporarily Deactivate User profile")
	@RequestMapping(value = "/secure/deactivate", method = RequestMethod.GET)
	ResponseEntity<?> deactivateUser() {
		logger.info("Temporarily deactivate user from website!");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userID = (String) auth.getPrincipal();		
		facade.deactivateUser(userID);
		return new ResponseEntity<>("success", HttpStatus.OK);
	}

	@ApiOperation(value = "View User Details", nickname = "View User Details")
	@ApiImplicitParam(name = "cookie", value = "Header Cookie Security Token", dataType = "string", paramType = "header")
	@RequestMapping(value = "/secure/get", method = RequestMethod.GET, produces = "application/json")
	User getDetails() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userID = (String) auth.getPrincipal();
		logger.info("View user Details!" + userID);
		return facade.getUser(userID);
	}

}
