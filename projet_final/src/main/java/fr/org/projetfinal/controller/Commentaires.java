package fr.org.projetfinal.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.org.projetfinal.metier.CommentaireMetierImp;
import fr.org.projetfinal.metier.ICommentaireMetier;
import fr.org.projetfinal.model.Commentaire;

public class Commentaires extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ICommentaireMetier commentaireMetier;
	
	@Override
	public void init() throws ServletException {
		commentaireMetier = new CommentaireMetierImp();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
		HttpSession session = request.getSession(false);
		
		if(session.getAttribute("user") == null) {
			response.sendRedirect("/projet_final/login");
		} else {
			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("id", id);
			request.getRequestDispatcher("/user/commentaire.jsp").forward(request, response);
		}
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pseudo = request.getParameter("pseudo");
		String contenu = request.getParameter("contenu");
		String date = request.getParameter("date");
		int article_id = Integer.parseInt(request.getParameter("article"));
		
		//On stocke dans un objet
		Commentaire commentaire = new Commentaire();
		commentaire.setPseudo(pseudo);
		commentaire.setContenu(contenu);
		commentaire.setDate(date);
		commentaire.setArticle_id(article_id);
		
		//Envoi dans la BDD
		try {
			commentaireMetier.postComment(commentaire);
			request.getRequestDispatcher("success.jsp").forward(request, response);
			System.out.println("Commentaire posté");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
