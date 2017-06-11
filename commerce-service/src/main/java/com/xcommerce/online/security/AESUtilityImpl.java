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
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.springframework.stereotype.Component;

/**
 * @author gabbu
 *
 */
@Component
public class AESUtilityImpl implements AESUtility {

	// TODO
	// this needs to be moved to config server properties
	private static final String AES_KEY = "LtJS6CRjZwTR0vXVpoy4ig==";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.xcommerce.online.security.AESUtility#generateSecurityToken(java.lang.
	 * String)
	 */
	@Override
	public String generateSecurityToken(String userID) throws NoSuchAlgorithmException, NoSuchProviderException,
			NoSuchPaddingException, UnsupportedEncodingException, InvalidKeyException,
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {

		Cipher cipher = initializeCipher(Cipher.ENCRYPT_MODE);

		// apply AES encryption to generate the final token
		byte[] encryptedToken = cipher.doFinal(userID.getBytes("UTF-8"));

		// return the hex encoded string
		return DatatypeConverter.printHexBinary(encryptedToken);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.xcommerce.online.security.AESUtility#validateSecurityToken(java.lang.
	 * String, java.lang.String)
	 */
	@Override
	public String validateSecurityToken(String token) throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException {

		Cipher cipher = initializeCipher(Cipher.DECRYPT_MODE);

		byte[] encryptedToken = DatatypeConverter.parseHexBinary(token);
		String user = null;
		try {
			user = new String(cipher.doFinal(encryptedToken), "UTF-8");
		} catch (Exception ex) {
			// stay silent
		}
		return user;
	}

	/**
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 */
	private Cipher initializeCipher(int mode)
			throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
		// do base64 decoding to get back the original secret key
		byte[] decodedKey = Base64.getDecoder().decode(AES_KEY);
		SecretKey key = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");

		// initialize the cipher
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(mode, key);
		return cipher;
	}

}
