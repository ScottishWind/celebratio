/**
 * 
 */
package com.xcommerce.online.user.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xcommerce.online.user.model.User;
import com.xcommerce.online.user.repository.UserRepository;

/**
 * @author gabbu
 *
 */
@Component
public class UseDaoImpl implements UseDao<User> {

	@Autowired
	private UserRepository repository;

	@Override
	public void insertUser(User user) {
		// TODO Auto-generated method stub
		repository.insert(user);

	}

	@Override
	public void updateUser(User user) {
		repository.save(user);

	}

	@Override
	public void deactivateUserByID(String userID) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUserByID(String userID) {
		repository.delete(userID);

	}

	@Override
	public User getUserByID(String userID) {
		return repository.findOne(userID);
	}

	@Override
	public void deleteAllUser() {
		repository.deleteAll();

	}

	@Override
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return repository.findByEmail(email);
	}

}
