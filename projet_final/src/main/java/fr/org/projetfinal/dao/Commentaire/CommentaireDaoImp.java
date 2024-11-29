package fr.org.projetfinal.dao.Commentaire;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.org.projetfinal.bdd.MyConnectionSQL;
import fr.org.projetfinal.model.Commentaire;

public class CommentaireDaoImp implements ICommentaireDao {

	private Connection connection;

	@Override
	public Commentaire addComment(Commentaire commentaire) throws Exception {
		
		this.connection = MyConnectionSQL.getInstance();
		
		try {
			String query = "INSERT INTO commentaires (pseudo, contenu, date, article_id) VALUES (?, ?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, commentaire.getPseudo());
			ps.setString(2, commentaire.getContenu());
			ps.setString(3, commentaire.getDate());
			ps.setInt(4, commentaire.getArticle_id());
			
			ps.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return commentaire;
	}

	@Override
	public List<Commentaire> getAllComments() throws Exception {
		
		List<Commentaire> commentaires = new ArrayList<Commentaire>();
		this.connection = MyConnectionSQL.getInstance();
		
		try {
			
			String query = "SELECT * FROM commentaires";
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				Commentaire commentaire = new Commentaire();
				commentaire.setId(rs.getInt("id"));
				commentaire.setPseudo(rs.getString("pseudo"));
				commentaire.setContenu(rs.getString("contenu"));
				commentaire.setDate(rs.getString("date"));
				commentaire.setArticle_id(rs.getInt("article_id"));
				
				commentaires.add(commentaire);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return commentaires;
	}

	@Override
	public List<Commentaire> getAllCommentsById(int id) throws Exception {
		List<Commentaire> commentaires = new ArrayList<Commentaire>();
		this.connection = MyConnectionSQL.getInstance();
		
		try {
			
			String query = "SELECT * FROM commentaires WHERE id = ?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Commentaire commentaire = new Commentaire();
				commentaire.setPseudo(rs.getString("pseudo"));
				commentaire.setContenu(rs.getString("contenu"));
				commentaire.setDate(rs.getString("date"));
				commentaire.setArticle_id(rs.getInt("article_id"));
				
				commentaires.add(commentaire);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return commentaires;
	}

	@Override
	public void deleteComment(int id) throws Exception {
		this.connection = MyConnectionSQL.getInstance();
		try {
			
			String query = "DELETE FROM commentaires WHERE id = ?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
