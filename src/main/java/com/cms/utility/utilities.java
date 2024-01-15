package com.cms.utility;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.springframework.stereotype.Component;

@Component
public class utilities {
	
	private static final Random random = new SecureRandom(); 
	
	private static final String characters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"; 

	private static final int iterations = 10000;  
	    
	private static final int keylength = 256;  
	
	
//	Generate Salt 
	public String generateSaltValue(int length){
		
		StringBuilder salt = new StringBuilder(length);
		
		for(int i = 0 ; i < length ; i++) {
			
			salt.append(characters.charAt(random.nextInt(characters.length())));
		}
		
		return new String(salt);
	}
	
	
//	Generate Hash
	public byte[] hash(char[] password, byte[] salt){
		
		PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, keylength);
		
		Arrays.fill(password, Character.MIN_VALUE);
		
		try {
		
			SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			return skf.generateSecret(spec).getEncoded();
		
		}catch(NoSuchAlgorithmException | InvalidKeySpecException e) {
		
			throw new AssertionError("Error While Hashing a password: "+ e.getMessage(), e);
		
		}finally {
			spec.clearPassword();
		}
		
	}
	
	
	// Encrypt Password using hashing and salt
	public String encryptPassword(String password, String salt) {

		String pass = null;
		
		byte[] securePassword = hash(password.toCharArray(), salt.getBytes());
		
		pass = Base64.getEncoder().encodeToString(securePassword);
		
		return pass;
	}
	
	
	
	// Verify Password
	public boolean verifyUserPassword(String ProvidedPassword, String securedPassword, String salt) {
		
		boolean pass = false;
		
		String newSecurePassword = encryptPassword(securedPassword, salt);
		
		pass = newSecurePassword.equals(securedPassword);

		return pass;
		
	}

}