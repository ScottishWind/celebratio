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
	public void deactivateUserByEmail(String email) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUserByEmail(String email) {
		repository.deleteByEmail(email);
		
	}

	@Override
	public User getUserByEmail(String email) {
		return repository.findByEmail(email);	
	}

}
