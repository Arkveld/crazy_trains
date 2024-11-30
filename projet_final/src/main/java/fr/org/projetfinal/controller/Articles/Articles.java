package fr.org.projetfinal.controller.Articles;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.org.projetfinal.metier.ArticleMetierImp;
import fr.org.projetfinal.metier.IArticleMetier;
import fr.org.projetfinal.model.Article;

@WebServlet(name = "/Articles")
public class Articles extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private IArticleMetier articleMetier;
	
	@Override
	public void init() throws ServletException {
		articleMetier = new ArticleMetierImp();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recupère tous les articles
		List<Article> articles = new ArrayList<Article>();
		try {
			articles = articleMetier.findArticles();
			request.setAttribute("articles", articles);
		}catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/pages/articles/articles.jsp").forward(request, response);
	}

}
