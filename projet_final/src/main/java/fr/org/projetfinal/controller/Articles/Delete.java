package fr.org.projetfinal.controller.Articles;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.org.projetfinal.metier.ArticleMetierImp;
import fr.org.projetfinal.metier.IArticleMetier;

@WebServlet(name = "/Delete")
public class Delete extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private IArticleMetier articleMetier;
	
	@Override
	public void init() throws ServletException {
		articleMetier = new ArticleMetierImp();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
		HttpSession session = request.getSession(false);
		if(session.getAttribute("user") == null) {
			response.sendRedirect("/projet_final/login");
		}
		int id = Integer.parseInt(request.getParameter("id"));
		
		try {
			articleMetier.delete(id);
			response.sendRedirect("/projet_final/success");
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		
	}

}