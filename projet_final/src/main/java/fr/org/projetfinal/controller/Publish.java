package fr.org.projetfinal.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.org.projetfinal.metier.CategorieMetierImp;
import fr.org.projetfinal.metier.ICategorieMetier;

import fr.org.projetfinal.model.Categorie;

@WebServlet(name="/Publish")
public class Publish extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private ICategorieMetier categorieMetier;
	
	@Override
	public void init() throws ServletException {
		this.categorieMetier = new CategorieMetierImp();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("user") == null) {
			response.sendRedirect("/projet_final/login");
		} else {
			
			try {
				List<Categorie> categories = categorieMetier.findAllCategories();
				request.setAttribute("categories", categories);
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher("/articles/saveArticle.jsp").forward(request, response);
		}
		
	}

}
