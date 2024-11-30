package fr.org.projetfinal.controller.Articles;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.org.projetfinal.metier.ArticleMetierImp;
import fr.org.projetfinal.metier.CommentaireMetierImp;
import fr.org.projetfinal.metier.IArticleMetier;
import fr.org.projetfinal.metier.ICommentaireMetier;
import fr.org.projetfinal.model.Article;
import fr.org.projetfinal.model.Commentaire;

@WebServlet(name = "/Single")
public class Single extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private IArticleMetier articleMetier;
	private ICommentaireMetier commentaireMetier;
	
	@Override
	public void init() throws ServletException {
		articleMetier = new ArticleMetierImp();
		commentaireMetier = new CommentaireMetierImp();
	}
	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Récuperation du paramètre dans l'url
		int id = Integer.parseInt(request.getParameter("id"));
		
		//Récuperation de l'article ayant cet id
		try {
			
			Article article = articleMetier.findOne(id);
			List<Commentaire> commentaires = commentaireMetier.findAllCommentsById(id);
			
			if(article != null) {
				request.setAttribute("article", article);
				request.setAttribute("commentaires", commentaires);
				request.getRequestDispatcher("/pages/articles/single.jsp").forward(request, response);
				
			} else {
				request.getRequestDispatcher("/pages/error.jsp").forward(request, response);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
