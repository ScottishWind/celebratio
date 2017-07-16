/**
 * 
 */
package com.xcommerce.online.security.filter;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

import com.xcommerce.online.security.AESUtility;
import com.xcommerce.online.security.AESUtilityImpl;
import com.xcommerce.online.security.model.AuthenticatedUser;

public class AuthenticationFilter extends OncePerRequestFilter {

	private AESUtility securityUtil = new AESUtilityImpl();

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		// validate the request header token and retrieve the user
		Cookie cookie = WebUtils.getCookie(request, "SECURITY-TOKEN");
		String userID = null;
		try {
			userID = securityUtil.validateSecurityToken(cookie.getValue());
			//userID = securityUtil.validateSecurityToken("AB62B93BBD5F42E250C6745599C1136D");
		} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException
				| BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IOException("Access Denied!");
		}

		// set a new cookie if the response for the user
		try {
			cookie = new Cookie("SECURITY-TOKEN", securityUtil.generateSecurityToken(userID));
			cookie.setPath("/");
			response.addCookie(cookie);
		} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchProviderException | NoSuchPaddingException
				| InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Create our Authentication and let Spring know about it
		Authentication auth = new AuthenticatedUser(userID);
		SecurityContextHolder.getContext().setAuthentication(auth);

		filterChain.doFilter(request, response);
	}

}
