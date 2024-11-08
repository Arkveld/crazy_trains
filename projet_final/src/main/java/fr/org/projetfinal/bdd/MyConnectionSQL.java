package fr.org.projetfinal.bdd;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnectionSQL {
	
	private static Connection instance;
	
	private MyConnectionSQL() {
		
	}

	//Singleton
	public static Connection getInstance() {
		
		if(instance == null) {
			instance = new MyConnectionSQL().getConnection();
		}
		
		return instance;
	}
	
	//Connexion à la BDD
	private Connection getConnection() {
		
		//Driver MySQL
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		//Création de l'objet connection
		try {
			 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp_servlet?serverTimeZone=UTC", "root", "");
			 return connection;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	
}
