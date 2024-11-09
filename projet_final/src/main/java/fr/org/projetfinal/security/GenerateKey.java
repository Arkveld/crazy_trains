package fr.org.projetfinal.security;

import java.security.Key;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public abstract class GenerateKey {

	public static Key getkey(String algorithme, int keySize) throws Exception {
		
		//Générateur de Key
		KeyGenerator keyGen = KeyGenerator.getInstance(algorithme);
		//Initialise la clé
		keyGen.init(keySize);
		
		//Crée la clé secrète
		SecretKey secretKey = keyGen.generateKey();
		
		//Obtention de la clé
		Key key = new SecretKeySpec(secretKey.getEncoded(), algorithme);
		return key;
		
		
	}
}
