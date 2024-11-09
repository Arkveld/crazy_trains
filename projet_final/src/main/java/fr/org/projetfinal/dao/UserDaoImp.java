package fr.org.projetfinal.dao;

import java.security.Key;
import java.sql.Connection;
import java.sql.PreparedStatement;

import fr.org.projetfinal.bdd.MyConnectionSQL;
import fr.org.projetfinal.model.User;
import fr.org.projetfinal.security.AlgoCryptage;
import fr.org.projetfinal.security.GenerateKey;

public class UserDaoImp implements IUserDao {
	
	private Connection connection;

	@Override
	public User addUser(User user) throws Exception {
		
		//Connexion
		this.connection = MyConnectionSQL.getInstance();
		
		try {
			
			//PrepareStatement
			PreparedStatement prepareStatement = connection.prepareStatement("INSERT INTO user (nom, prenom, mail, password, role, question_id, reponse) VALUES (?, ?, ?, ?, ?, ?, ?)");
			prepareStatement.setString(1, user.getNom());
			prepareStatement.setString(2, user.getPrenom());
			prepareStatement.setString(3, user.getEmail());
			
			
			//Cryptage du mot de passe
			Key key = GenerateKey.getkey("DES", 56);
			byte[] passwordCrypted = AlgoCryptage.encrypt(user.getPassword(), key, "DES");
			prepareStatement.setBytes(4, passwordCrypted);
			
			prepareStatement.setString(5, user.getRole());
			prepareStatement.setInt(6, user.getQuestion_id());
			prepareStatement.setString(7, user.getRole());
			
			prepareStatement.executeUpdate();
			
			prepareStatement.close();
			connection.close();
			
		} catch(Exception e) {
			
		}
		
		
	
		
		
		return user;
	}

}
