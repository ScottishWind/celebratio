/**
 * 
 */
package com.xcommerce.online.user.facade;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xcommerce.online.security.AESUtility;
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
	
	@Autowired
	private AESUtility securityUtil;

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

	@Override
	public String getToken(String userID) {
		// TODO Auto-generated method stub
		String token =null;
		try {
			token = securityUtil.generateSecurityToken(userID);
		} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchProviderException | NoSuchPaddingException
				| UnsupportedEncodingException | InvalidAlgorithmParameterException | IllegalBlockSizeException
				| BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return token;
	}

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return service.login(user);
	}

}
