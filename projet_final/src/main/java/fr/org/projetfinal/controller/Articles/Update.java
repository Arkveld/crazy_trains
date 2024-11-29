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

@WebServlet(name ="/Update")
public class Update extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private IArticleMetier articleMetier;
	private ICategorieMetier categorieMetier;
	private String messageError = "";
	
	@Override
	public void init() throws ServletException {
		articleMetier = new ArticleMetierImp();
		categorieMetier = new CategorieMetierImp();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
		HttpSession session = request.getSession(false);
		
		if(session.getAttribute("user") == null) {
			response.sendRedirect("/projet_final/login");
		}
		
		//Récupère le paramètre
		int id = Integer.parseInt(request.getParameter("id"));
		//Récupère l'article selon l'id
		try {
			Article article = articleMetier.findOne(id);
			List<Categorie> categories =  categorieMetier.findAllCategories();
			request.setAttribute("categories", categories);
			request.setAttribute("article", article);
			request.getRequestDispatcher("/articles/updateArticle.jsp").forward(request, response);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//On récupère les données du formulaire puis on stocke dans un objet
		int id = Integer.parseInt(request.getParameter("id"));
		String titre = request.getParameter("titre");
		String contenu = request.getParameter("contenu");
		int categorie = Integer.parseInt(request.getParameter("categorie"));
		String legende = request.getParameter("legende");
		String date = request.getParameter("date");
		int auteur = Integer.parseInt(request.getParameter("auteur"));
		Part part = request.getPart("image");
		
		//Récupère le nom du fichier
		String filename = articleMetier.getFileName(part);
		
		//Verifie le format du fichier
		Boolean typeFile = articleMetier.verifyFormatFile(filename);
		
		if(typeFile) {
			
			messageError = "Le format doit être png ou jpg";
			request.setAttribute("messageError", messageError);
			request.getRequestDispatcher("/articles/updateArticle.jsp").forward(request, response);
		} 
		//On stocke les données dans un objet Article
		Article article = new Article();
		article.setTitre(titre);
		article.setCategorie_id(categorie);
		article.setUser_id(auteur);
		article.setContenu(contenu);
		article.setDate(date);
		article.setImageUrl(filename);
		article.setLegende(legende);
		System.out.println(article);
		//Upload du fichier
		articleMetier.uploadFile(part);
			
		//Modifier dans la BDD
		try {
			articleMetier.update(article, id);
			response.sendRedirect("/projet_final/success");
			//request.getRequestDispatcher("/articles/updateArticle.jsp").forward(request, response);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Update failed");
				
		}
			
	}
			
	
}
