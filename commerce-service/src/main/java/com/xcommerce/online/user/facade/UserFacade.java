/**
 * 
 */
package com.xcommerce.online.user.facade;

import com.xcommerce.online.user.model.User;

/**
 * @author gabbu
 *
 */
public interface UserFacade<T extends User> {

	public void createUser(T user);

	public void modifyUser(T user);

	public void deactivateUser(String userID);

	public void deleteUser(String userID);

	public User getUser(String userID);

	public void deleteAllUser();

	public String getToken(String userID);

	public T login(T user);

}
