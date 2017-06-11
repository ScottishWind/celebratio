/**
 * 
 */
package com.xcommerce.online.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xcommerce.online.user.dao.UseDao;
import com.xcommerce.online.user.model.User;

/**
 * @author gabbu
 *
 */
@Component
public class UserServiceImpl implements UserService<User> {

	@Autowired
	private UseDao<User> userDao;

	@Override
	public void createUser(User user) {
		userDao.insertUser(user);

	}

	@Override
	public void modifyUser(User user) {
		userDao.updateUser(user);

	}

	@Override
	public void deactivateUser(String email) {
		userDao.deactivateUserByEmail(email);

	}

	@Override
	public void deleteUser(String email) {
		userDao.deleteUserByEmail(email);

	}

	@Override
	public User getUser(String email) {
		return userDao.getUserByEmail(email);

	}

	@Override
	public void deleteAllUser() {
		userDao.deleteAllUser();
		
	}

}
