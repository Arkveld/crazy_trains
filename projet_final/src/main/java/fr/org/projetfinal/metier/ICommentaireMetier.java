package fr.org.projetfinal.metier;

import java.util.List;

import fr.org.projetfinal.model.Commentaire;

public interface ICommentaireMetier {

	public Commentaire postComment(Commentaire commentaire) throws Exception;
	public List<Commentaire> findAllComments() throws Exception;
	public List<Commentaire> findAllCommentsById(int id) throws Exception;
	public void delete(int id) throws Exception;
	//Vérification des inputs
	public boolean verifyInput(String regex, String value);
}
