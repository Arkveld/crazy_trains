package fr.org.projetfinal.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.org.projetfinal.metier.ArticleMetierImp;
import fr.org.projetfinal.metier.IArticleMetier;
import fr.org.projetfinal.model.Article;

@WebServlet(name = "/Single")
public class Single extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private IArticleMetier articleMetier;
	
	@Override
	public void init() throws ServletException {
		articleMetier = new ArticleMetierImp();
	}
	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Récuperation du paramètre dans l'url
		int id = Integer.parseInt(request.getParameter("id"));
		
		//Récuperation de l'article ayant cet id
		try {
			
			Article article = articleMetier.findOne(id);
			request.setAttribute("article", article);
			request.getRequestDispatcher("/articles/single.jsp").forward(request, response);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		System.out.println(id);
	}

}
