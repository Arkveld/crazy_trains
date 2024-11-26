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
	public Article addArticle(Article article) throws Exception {
		
		//id
		int id = 0;
		//MySql
		this.connection = MyConnectionSQL.getInstance();
		//Client MongoDB
		this.mongoConnection = MongoConnection.getInstance();
		
		
		try {
			//Connexion à la BDD mySQL
			String query = "INSERT INTO articles (titre, contenu, date, user_id, categorie_id)  VALUES (?, ?, ?, ?, ?)";
			PreparedStatement prepareStatement = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			prepareStatement.setString(1, article.getTitre());
			prepareStatement.setString(2, article.getContenu());
			prepareStatement.setString(3, article.getDate());
			prepareStatement.setInt(4, article.getUser_id());
			prepareStatement.setInt(5, article.getCategorie_id());
			
			prepareStatement.executeUpdate();
			
			//On récupère le dernier id inséree
			ResultSet rs = prepareStatement.getGeneratedKeys();
			if(rs.next()) {
				id = rs.getInt(1);
			}
			
			//Connexion à MongoDB
			MongoDatabase database = mongoConnection.getDatabase("train");
			
			MongoCollection<Document> collection = database.getCollection("articles");
			Document document = new Document("id", id).append("url", article.getImageUrl()).append("legende", article.getLegende());
			collection.insertOne(document);
			
			//On ferme la seesion
			prepareStatement.close();
			mongoConnection.close();
			connection.close();
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return article;
		
	}
	
	

}
