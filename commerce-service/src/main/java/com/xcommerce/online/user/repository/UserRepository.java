package com.xcommerce.online.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.xcommerce.online.user.model.User;

public interface UserRepository extends MongoRepository<User, String> {

	/**
	 * find User by Email
	 * 
	 * @param email
	 * @return
	 */
	public User findByEmail(String email);
	
	/**
	 * delete User by Email
	 * 
	 * @param email
	 * @return
	 */
	public void deleteByEmail(String email);

}
