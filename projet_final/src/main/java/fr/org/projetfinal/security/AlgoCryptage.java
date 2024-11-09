package fr.org.projetfinal.security;

import java.nio.charset.StandardCharsets;
import java.security.Key;

import javax.crypto.Cipher;

public abstract class AlgoCryptage {

	
	//Cryptage
	public static byte[] encrypt(String passwordToEncrypt, Key key, String algorithme) throws Exception {
		
		//Cipher
		Cipher cipher = Cipher.getInstance(algorithme);
		
		//Initialisation
		cipher.init(Cipher.ENCRYPT_MODE, key);
		
		byte[] passwordCrypted = cipher.doFinal(passwordToEncrypt.getBytes(StandardCharsets.UTF_8));
		return passwordCrypted;
	}
}
