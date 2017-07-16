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
	public void deactivateUser(String userID) {
		userDao.deactivateUserByID(userID);

	}

	@Override
	public void deleteUser(String userID) {
		userDao.deleteUserByID(userID);

	}

	@Override
	public User getUser(String userID) {
		return userDao.getUserByID(userID);

	}

	@Override
	public void deleteAllUser() {
		userDao.deleteAllUser();

	}

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		User userFromDB = userDao.getUserByEmail(user.getEmail());
		if (userFromDB != null) {
			if (user.getPassword().equals(userFromDB.getPassword())) {
				userFromDB.setPassword(null);
				return userFromDB;
			}
		}
		return null;
	}
}
