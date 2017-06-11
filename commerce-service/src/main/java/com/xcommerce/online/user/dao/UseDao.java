/**
 * 
 */
package com.xcommerce.online.user.dao;

import com.xcommerce.online.user.model.User;

/**
 * @author gabbu
 *
 */
public interface UseDao<T extends User> {
	
	public void insertUser(T user);
	
	public void updateUser(T user);
	
	public void deactivateUserByID(String email);
	
	public void deleteUserByID(String email);
	
	public User getUserByID(String email);
	
	public void deleteAllUser();
	

}
