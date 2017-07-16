/**
 * 
 */
package com.xcommerce.online.security.model;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author gabbu
 *
 */
public class AuthenticatedUser extends AbstractAuthenticationToken {

	private static final long serialVersionUID = 1L;
	private String userID;

	public AuthenticatedUser(Collection<? extends GrantedAuthority> arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public AuthenticatedUser(String userID) {
		super(Arrays.asList());
		this.userID = userID;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.core.Authentication#getCredentials()
	 */
	@Override
	public Object getCredentials() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.core.Authentication#getPrincipal()
	 */
	@Override
	public Object getPrincipal() {
		// TODO Auto-generated method stub
		return userID;
	}

}
