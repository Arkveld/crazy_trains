package fr.org.projetfinal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import fr.org.projetfinal.bdd.MyConnectionSQL;
import fr.org.projetfinal.model.User;

public class UserDaoImp implements IUserDao {
	
	private Connection connection;

	@Override
	public User addUser(User user) throws Exception {
		
		//Connexion
		this.connection = MyConnectionSQL.getInstance();
		
		//PrepareStatement
		PreparedStatement prepareStatement = connection.prepareStatement("INSERT INTO user (nom, prenom, mail, password, role, question_id, reponse) VALUES (?, ?, ?, ?, ?, ?, ?)");
		prepareStatement.setString(1, user.getNom());
		prepareStatement.setString(2, user.getPrenom());
		prepareStatement.setString(3, user.getEmail());
		//Cryptage
		
		//prepareStatement.setBytes(4, user.getPassword().getBytes());
		
		prepareStatement.setString(5, user.getRole());
		prepareStatement.setInt(6, user.getQuestion_id());
		prepareStatement.setString(7, user.getRole());
		
		prepareStatement.executeUpdate();
		
	
		prepareStatement.close();
		connection.close();
		
		return user;
	}

}
