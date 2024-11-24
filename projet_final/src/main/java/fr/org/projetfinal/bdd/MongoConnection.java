package fr.org.projetfinal.bdd;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;


public class MongoConnection {
	
	private static MongoDatabase instance;
	
	private MongoConnection() {
		
	}

	public static MongoDatabase getInstance() {
		
		try {
			
			if(instance == null) {
				String uri = "mongodb://localhost:27017";
				MongoClient mongoClient = MongoClients.create(uri);
				
				//Connexion a la BDD
				instance = mongoClient.getDatabase("trains");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return instance;
	
	}
	
	

}
