package fr.org.projetfinal.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.org.projetfinal.metier.ArticleMetierImp;
import fr.org.projetfinal.metier.IArticleMetier;
import fr.org.projetfinal.model.Article;
import fr.org.projetfinal.model.User;

@WebServlet(name = "/Admin")
public class Admin extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private IArticleMetier articleMetier;
	
	@Override
	public void init() throws ServletException {
		articleMetier = new ArticleMetierImp();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
		if(session.getAttribute("user") == null){
			response.sendRedirect("/projet_final/login");
		 }
		//On récupère l'user dans la session
		User user = (User) session.getAttribute("user");
		
		
		if (user.getRole().equals("admin")) {
			
			//On récupère tous les articles
			try {
				List<Article> articles = articleMetier.findArticles();
				request.setAttribute("articles", articles);
			} catch(Exception e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher("admin/admin.jsp").forward(request, response);
		} else {
			
			request.getRequestDispatcher("user/login.jsp").forward(request, response);
		}
		
		
	}
}
