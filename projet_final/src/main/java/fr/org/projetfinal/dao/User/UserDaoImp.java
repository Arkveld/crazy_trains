package fr.org.projetfinal.dao.User;

import java.security.Key;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.spec.SecretKeySpec;

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
			PreparedStatement prepareStatement = connection.prepareStatement("INSERT INTO users (nom, prenom, mail, password, cle_pwd, question_id, reponse, role) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			prepareStatement.setString(1, user.getNom());
			prepareStatement.setString(2, user.getPrenom());
			prepareStatement.setString(3, user.getEmail());
			
			
			//Cryptage du mot de passe
			Key key = GenerateKey.getkey("DES", 56);
			byte[] passwordCrypted = AlgoCryptage.encrypt(user.getPassword(), key, "DES");
			prepareStatement.setBytes(4, passwordCrypted);
			
			//Envoie de la clé
			prepareStatement.setBytes(5, key.getEncoded());
			
			prepareStatement.setInt(6, user.getQuestion_id());
			prepareStatement.setString(7, user.getReponse());
			prepareStatement.setString(8, user.getRole());
			
			prepareStatement.executeUpdate();
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Erreur lors de la reqûete");
		}
		
		return user;
	}

	@Override
	public User getUserByEmail(String mail) throws Exception {
		// TODO Auto-generated method stub
		
		//Connexion
		this.connection = MyConnectionSQL.getInstance();
		
		//Initialisation d'un user
		User user = new User();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `users` INNER JOIN questions ON users.question_id = questions.id WHERE mail= ?");
			preparedStatement.setString(1, mail);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				user.setId(resultSet.getInt("id"));
				user.setNom(resultSet.getString("nom"));
				user.setPrenom(resultSet.getString("prenom"));
				user.setEmail(resultSet.getString("mail"));
				user.setQuestion_id(resultSet.getInt("question_id"));
				user.setReponse(resultSet.getString("reponse"));
				user.setRole(resultSet.getString("role"));
				
				//Décryptage du mot de passe
				Key key = new SecretKeySpec(resultSet.getBytes("cle_pwd"), "DES");
				String password = AlgoCryptage.decrypt(resultSet.getBytes("password"), key, "DES");
				user.setPassword(password);
			}
			
			
			
			return user;
			
		} catch(Exception e ) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<User> getUsers() throws Exception {
		List<User> users = new ArrayList<User>();
		this.connection = MyConnectionSQL.getInstance();
		try {
			
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM users");
			
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setNom(rs.getString("nom"));
				user.setPrenom(rs.getString("prenom"));
				user.setEmail(rs.getString("mail"));
				
				users.add(user);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return users;
	}

	@Override
	public void update(User user, int id) throws Exception {
		this.connection= MyConnectionSQL.getInstance();
		
		try {
			
			String query = "UPDATE users SET nom = ?, prenom = ?, mail = ?, question_id = ?, reponse = ? WHERE id = ?";
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setString(1, user.getNom());
			ps.setString(2, user.getPrenom());
			ps.setString(3, user.getEmail());
			ps.setInt(4, user.getQuestion_id());
			ps.setString(5, user.getReponse());
			ps.setInt(6, id);
			
			ps.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int id) throws Exception {
		this.connection= MyConnectionSQL.getInstance();
		
		try {
			String query = "DELETE FROM users WHERE id = ?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public User getUserById(int id) throws Exception {
		
		//Connexion
		this.connection = MyConnectionSQL.getInstance();
		//Initialisation d'un user
		User user = new User();
		
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE id = ?");
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				user.setId(rs.getInt("id"));
				user.setNom(rs.getString("nom"));
				user.setPrenom(rs.getString("prenom"));
				user.setEmail(rs.getString("mail"));
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	
}
