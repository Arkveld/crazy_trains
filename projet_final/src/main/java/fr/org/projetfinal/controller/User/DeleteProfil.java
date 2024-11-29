package fr.org.projetfinal.controller.User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.org.projetfinal.metier.IUserMetier;
import fr.org.projetfinal.metier.UserMetierImp;

public class DeleteProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserMetier userMetier;
	
	@Override
	public void init() throws ServletException {
		userMetier = new UserMetierImp();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
		HttpSession session = request.getSession(false);
		
		if(session.getAttribute("user") == null) {
			response.sendRedirect("/projet_final/login");
		}
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		//Suppression de l'article
		try {
			userMetier.deleteUser(id);
			response.sendRedirect("/projet_final/");
			
		} catch(Exception e) {
			e.printStackTrace();		
		}
		
		
	}
	

}
