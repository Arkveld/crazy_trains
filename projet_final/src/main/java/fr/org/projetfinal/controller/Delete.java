package fr.org.projetfinal.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.org.projetfinal.metier.ArticleMetierImp;
import fr.org.projetfinal.metier.IArticleMetier;

public class Delete extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private IArticleMetier articleMetier;
	
	@Override
	public void init() throws ServletException {
		articleMetier = new ArticleMetierImp();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("user") == null) {
			response.sendRedirect("/projet_final/login");
		}
		int id = Integer.parseInt(request.getParameter("id"));
		
		try {
			articleMetier.delete(id);
			request.getRequestDispatcher("/articles/delete.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		
	}

}
