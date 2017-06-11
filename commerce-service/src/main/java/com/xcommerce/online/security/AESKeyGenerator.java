/**
 * 
 */
package com.xcommerce.online.security;

/**
 * @author gabbu
 *
 */
public class AESKeyGenerator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AESUtility aes = new AESUtilityImpl();
		try {
			System.out.println(aes.generateAESKey());
			//System.out.println(aes.generateSecurityToken("123456"));
			//System.out.println(aes.validateSecurityToken("123456",
			//"C12F537DDFB91F8A1A7F902D7809354D"));
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
