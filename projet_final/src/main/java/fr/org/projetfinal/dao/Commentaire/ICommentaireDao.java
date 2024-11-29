package fr.org.projetfinal.dao.Commentaire;

import java.util.List;

import fr.org.projetfinal.model.Commentaire;

public interface ICommentaireDao {
	
	//Ajouter un commentaire
	public Commentaire addComment(Commentaire commentaire) throws Exception;
	//Obtenir tous les commentaires
	public List<Commentaire> getAllComments() throws Exception;
	
	//Obtenir tous les commentaires selon l'id de l'article
	public List<Commentaire> getAllCommentsById(int articleId) throws Exception;
	
	//Supprimer un commentaire
	public void deleteComment(int id) throws Exception;
	
}
