/**
 * 
 */
package com.xcommerce.online.user.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xcommerce.online.user.model.User;
import com.xcommerce.online.user.service.UserService;

/**
 * @author gabbu
 *
 */
@Component
public class UserFacadeImpl implements UserFacade<User> {
	
	@Autowired
	private UserService<User> service;

	/* (non-Javadoc)
	 * @see com.xcommerce.online.user.facade.UserFacade#createUser(com.xcommerce.online.user.model.User)
	 */
	@Override
	public void createUser(User user) {
		service.createUser(user);

	}

	/* (non-Javadoc)
	 * @see com.xcommerce.online.user.facade.UserFacade#modifyUser(com.xcommerce.online.user.model.User)
	 */
	@Override
	public void modifyUser(User user) {
		service.modifyUser(user);

	}

	/* (non-Javadoc)
	 * @see com.xcommerce.online.user.facade.UserFacade#deactivateUser(java.lang.String)
	 */
	@Override
	public void deactivateUser(String userID) {
		User user = service.getUser(userID);
		user.setActive(false);
		service.modifyUser(user);
	}

	/* (non-Javadoc)
	 * @see com.xcommerce.online.user.facade.UserFacade#deleteUser(java.lang.String)
	 */
	@Override
	public void deleteUser(String userID) {
		service.deleteUser(userID);

	}

	/* (non-Javadoc)
	 * @see com.xcommerce.online.user.facade.UserFacade#getUser(java.lang.String)
	 */
	@Override
	public User getUser(String userID) {
		return service.getUser(userID);

	}

	@Override
	public void deleteAllUser() {
		service.deleteAllUser();
		
	}

}
