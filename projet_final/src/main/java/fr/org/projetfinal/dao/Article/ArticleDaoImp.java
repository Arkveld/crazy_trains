package fr.org.projetfinal.dao.Article;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

import fr.org.projetfinal.bdd.MongoConnection;
import fr.org.projetfinal.bdd.MyConnectionSQL;
import fr.org.projetfinal.model.Article;

public class ArticleDaoImp implements IArticleDao {

	private Connection connection;
	private MongoClient mongoConnection;
	
	@Override
	/********** Ajouter un article ****************/
	
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
			
			//On ferme la session
			//prepareStatement.close();
			//mongoConnection.close();
			//connection.close();
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return article;
		
	}
	
	@Override
	/**************Obtenir tous les articles ********************/
	
	public List<Article> getArticles() throws Exception {
		List<Article> articles = new ArrayList<Article>();
		//MySql
		this.connection = MyConnectionSQL.getInstance();
		try {
			String query = "SELECT * FROM articles";
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				
				Article article = new Article();
				article.setId(rs.getInt("id"));
				article.setTitre(rs.getString("titre"));
				article.setContenu(rs.getString("contenu"));
				article.setDate(rs.getString("date"));
				
				articles.add(article);
			}
			
			//On ferme la session
			//rs.close();
			//statement.close();
			//connection.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return articles;
	}

	@Override
	
	/************ Obtenir un article selon son id *************/
	
	public Article getArticleById(int id) throws Exception {
		Article article = new Article();
		
		this.connection = MyConnectionSQL.getInstance();
		this.mongoConnection = MongoConnection.getInstance();
		
		try {
			String query = "SELECT * FROM articles WHERE id = ?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				article.setId(rs.getInt("id"));
				article.setTitre(rs.getString("titre"));
				article.setContenu(rs.getString("contenu"));
				article.setDate(rs.getString("date"));
			}
			
			//rs.close();
			//ps.close();
			//connection.close();
			
			MongoDatabase database = mongoConnection.getDatabase("train");
			MongoCollection<Document> collection = database.getCollection("articles");
			Document cursor = collection.find(Filters.eq("id", id)).first();
			article.setImageUrl(cursor.getString("url"));
			article.setLegende(cursor.getString("legende"));
			
			//mongoConnection.close();
			
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return article;
	}

	/************ Modifier un article ***************/
	@Override
	public void updateArticle(Article article, int id) throws Exception {
		//MySql
		this.connection = MyConnectionSQL.getInstance();
		//Client MongoDB
		this.mongoConnection = MongoConnection.getInstance();
		
		try {
			
			//MySQL
			
			String query = "UPDATE articles SET titre = ?, contenu = ?, date = ?, user_id = ?, categorie_id = ? WHERE id = ?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, article.getTitre());
			ps.setString(2, article.getContenu());
			ps.setString(3, article.getDate());
			ps.setInt(4, article.getUser_id());
			ps.setInt(5, article.getCategorie_id());
			ps.setInt(6, id);
			
			ps.executeUpdate();
			
			//MongoDB
			MongoDatabase database = mongoConnection.getDatabase("train");
			MongoCollection<Document> collection = database.getCollection("articles");
			
			
			//On se place l'id du document à remplacer
			collection.updateOne(Filters.eq("id", id), Updates.set("url", article.getImageUrl()));
			collection.updateOne(Filters.eq("id", id), Updates.set("legende", article.getLegende()));
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void deleteArticle(int id) throws Exception {
		//MySql
		this.connection = MyConnectionSQL.getInstance();
		//Client MongoDB
		this.mongoConnection = MongoConnection.getInstance();
		
		try {
			
			//MySQL
			String query = "DELETE FROM articles WHERE id = ?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
			
			//MongoDB
			MongoDatabase database = mongoConnection.getDatabase("train");
			MongoCollection<Document> collection = database.getCollection("articles");
			collection.deleteOne(Filters.eq("id", id));
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	

}
