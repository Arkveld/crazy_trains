package fr.org.projetfinal.controller.Categories;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.org.projetfinal.metier.ArticleMetierImp;
import fr.org.projetfinal.metier.IArticleMetier;
import fr.org.projetfinal.model.Article;

@WebServlet(name = "/Trains")
public class Trains extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private IArticleMetier articleMetier;
	
	@Override
	public void init() throws ServletException {
		articleMetier = new ArticleMetierImp();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		request.getRequestDispatcher("/pages/categories/trains.jsp").forward(request, response);
		/**try {
			List<Article> articles = articleMetier.findArticlesByCategorie(1);
			request.setAttribute("articles", articles);
			
		}catch(Exception e) {
			e.printStackTrace();
		}**/
		
		
	}

}
