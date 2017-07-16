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

	public void deactivateUserByID(String userID);

	public void deleteUserByID(String userID);

	public User getUserByID(String userID);

	public User getUserByEmail(String email);

	public void deleteAllUser();

}
