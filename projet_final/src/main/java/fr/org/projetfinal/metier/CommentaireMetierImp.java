package fr.org.projetfinal.metier;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.org.projetfinal.dao.Commentaire.CommentaireDaoImp;
import fr.org.projetfinal.dao.Commentaire.ICommentaireDao;
import fr.org.projetfinal.model.Commentaire;

public class CommentaireMetierImp implements ICommentaireMetier {
	
	private ICommentaireDao commentaireDao = new CommentaireDaoImp();

	@Override
	public Commentaire postComment(Commentaire commentaire) throws Exception {
		return commentaireDao.addComment(commentaire);
	}

	@Override
	public List<Commentaire> findAllComments() throws Exception {
		return commentaireDao.getAllComments();
	}

	@Override
	public List<Commentaire> findAllCommentsById(int id) throws Exception {
		return commentaireDao.getAllCommentsById(id);
	}

	@Override
	public void delete(int id) throws Exception {
		commentaireDao.deleteComment(id);
		
	}

	@Override
	public boolean verifyInput(String regex, String value) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(value);
		
		return matcher.find();
	}

}
