/**
 * 
 */
package com.xcommerce.online.user.service;

import com.xcommerce.online.user.model.User;

/**
 * @author gabbu
 *
 */
public interface UserService<T extends User> {
		
	public void createUser(T user);
	
	public void modifyUser(T user);
	
	public void deactivateUser(String userID);
	
	public void deleteUser(String userID);
	
	public User getUser(String userID);
	
	public void deleteAllUser();
	
}
