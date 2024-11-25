package fr.org.projetfinal.dao.Article;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import fr.org.projetfinal.bdd.MongoConnection;
import fr.org.projetfinal.bdd.MyConnectionSQL;
import fr.org.projetfinal.model.Article;

public class ArticleDaoImp implements IArticleDao {

	private Connection connection;
	private MongoClient mongoConnection;
	@Override
	public void addArticle(Article article) throws Exception {
		
		//MySql
		this.connection = MyConnectionSQL.getInstance();
		//Client MongoDB
		this.mongoConnection = MongoConnection.getInstance();
		
		
		try {
			//Connexion à la BDD mySQL
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO (titre, contenu, date, user_id, categorie_id) article VALUES(?, ?, ?, ?, ?)");
			preparedStatement.setString(1, article.getTitre());
			preparedStatement.setString(2, article.getContenu());
			preparedStatement.setString(3, article.getDate());
			preparedStatement.setInt(4, article.getUser_id());
			preparedStatement.setInt(5, article.getCategorie_id());
			
			preparedStatement.executeUpdate();
			
			//On récupère le dernier id inséree
			Statement statement  = connection.createStatement();
			int id = statement.executeUpdate("SELECT MAX (id) * FROM articles");
			
			//Connexion à MongoDB
			MongoDatabase database = mongoConnection.getDatabase("trains");
			
			MongoCollection<Document> collection = database.getCollection("articles");
			Document document = new Document("id", id).append("url", article.getImageUrl()).append("legende", article.getLegende());
			collection.insertOne(document);
			
			//On ferme la seesion
			statement.close();
			preparedStatement.close();
			mongoConnection.close();
			connection.close();
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	

}
