package utility;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncryption{
	
	private String salt = "secure";
	private int stretchCount = 10;
	
	public String getPassword_encryption(String data){
		String encryptedPassword = "";
		for(int i=0; i<stretchCount; i++){
			encryptedPassword = getSha256(salt + data);
		}
		return encryptedPassword;
	}

	private String getSha256(String text) {
		// TODO Auto-generated method stub
		MessageDigest md = null;
		StringBuffer buf = new StringBuffer();
		try{
			md = MessageDigest.getInstance("SHA-256");
			md.update(text.getBytes());
			byte[] digest = md.digest();
			
			for(int i=0; i<digest.length; i++){
				buf.append(String.format("%02x", digest[i]));
			}
		}catch(NoSuchAlgorithmException e){
			e.printStackTrace();
		}
		return buf.toString();
	}
}