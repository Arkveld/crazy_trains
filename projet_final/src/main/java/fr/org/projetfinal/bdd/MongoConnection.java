package fr.org.projetfinal.bdd;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;



public class MongoConnection {
	
	private static MongoClient instance;
	
	private MongoConnection() {
		
	}

	public static MongoClient getInstance() {
		
		try {
			
			if(instance == null) {
				
				instance = MongoClients.create("mongodb://localhost:27017");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return instance;
	
	}
	
	

}
