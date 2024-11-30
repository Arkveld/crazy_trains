package fr.org.projetfinal.controller.Articles;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import fr.org.projetfinal.metier.ArticleMetierImp;
import fr.org.projetfinal.metier.CategorieMetierImp;
import fr.org.projetfinal.metier.IArticleMetier;
import fr.org.projetfinal.metier.ICategorieMetier;
import fr.org.projetfinal.model.Article;
import fr.org.projetfinal.model.Categorie;

@WebServlet(name = "/Publish")
public class Publish extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private ICategorieMetier categorieMetier;
	private IArticleMetier articleMetier;
	private String messageError = "";
	
	@Override
	public void init() throws ServletException {
		this.categorieMetier = new CategorieMetierImp();
		this.articleMetier = new ArticleMetierImp();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
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
			request.getRequestDispatcher("/pages/articles/saveArticle.jsp").forward(request, response);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("title");
		int categorie = Integer.parseInt(request.getParameter("categorie"));
		String date = request.getParameter("date");
		int auteur = Integer.parseInt(request.getParameter("auteur"));
		String contenu = request.getParameter("contenu");
		String legende = request.getParameter("legende");
		//Récupération du fichier
		Part part = request.getPart("image");
		
		//Récupère le nom du fichier
		String filename = articleMetier.getFileName(part);
		
		//Verifie le format du fichier
		Boolean typeFile = articleMetier.verifyFormatFile(filename);
		if(!typeFile) {
			messageError = "Le format doit être png ou jpg";
			request.setAttribute("messageError", messageError);
			request.getRequestDispatcher("/pages/articles/saveArticle.jsp").forward(request, response);
		} else {
			
			//On stocke les données dans un objet Article
			Article article = new Article();
			article.setTitre(title);
			article.setCategorie_id(categorie);
			article.setUser_id(auteur);
			article.setContenu(contenu);
			article.setDate(date);
			article.setImageUrl(filename);
			article.setLegende(legende);
			
			//Upload du fichier
			articleMetier.uploadFile(part);
			
			//Envoi vers la BDD
			try {
				Article articleSaved = articleMetier.saveArticle(article);
				response.sendRedirect("/projet_final/success");
				//request.getRequestDispatcher("/user/profil.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Echec de l'envoi");
			}
		}
		
	}

}
