/**
 * 
 */
package com.xcommerce.online.security;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

/**
 * @author gabbu
 *
 */
public interface AESUtility {

	/**
	 * method used for generating the security token
	 * 
	 * @param userID
	 * @return
	 * @throws NoSuchPaddingException
	 * @throws NoSuchProviderException
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 * @throws InvalidAlgorithmParameterException
	 * @throws InvalidKeyException
	 * @throws BadPaddingException
	 * @throws IllegalBlockSizeException
	 */
	public String generateSecurityToken(String userID) throws NoSuchAlgorithmException, NoSuchProviderException,
			NoSuchPaddingException, UnsupportedEncodingException, InvalidKeyException,
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException;

	/**
	 * method to validate the provided security token for a user
	 * 
	 * @param userID
	 * @param token
	 * @return
	 * @throws NoSuchPaddingException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
	 * @throws BadPaddingException
	 * @throws IllegalBlockSizeException
	 * @throws UnsupportedEncodingException
	 */
	public Boolean validateSecurityToken(String userID, String token)
			throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, UnsupportedEncodingException,
			IllegalBlockSizeException, BadPaddingException;

	/**
	 * Method used to generate AES Key
	 * 
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	default String generateAESKey() throws NoSuchAlgorithmException {
		KeyGenerator kgen = KeyGenerator.getInstance("AES");
		SecretKey aesKey = kgen.generateKey();
		return Base64.getEncoder().encodeToString(aesKey.getEncoded());
	}

}
