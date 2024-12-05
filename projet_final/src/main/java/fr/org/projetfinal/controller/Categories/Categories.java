package fr.org.projetfinal.controller.Categories;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.org.projetfinal.metier.CategorieMetierImp;
import fr.org.projetfinal.metier.ICategorieMetier;
import fr.org.projetfinal.model.Categorie;

@WebServlet(name = "/Categories")
public class Categories extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ICategorieMetier categorieMetier;
	
	@Override
	public void init() throws ServletException {
		categorieMetier = new CategorieMetierImp();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Liste de catégories
		try {
			List<Categorie> categories = categorieMetier.findAllCategories();
			request.setAttribute("categories", categories);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/pages/categories/categories.jsp").forward(request, response);
	}

}
