package fr.org.projetfinal.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.org.projetfinal.metier.IUserMetier;
import fr.org.projetfinal.metier.UserMetierImp;
import fr.org.projetfinal.model.User;

@WebServlet(name = "/Authentification")
public class Authentification extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private IUserMetier userMetier;
	
	@Override
	public void init() throws ServletException {
		userMetier = new UserMetierImp();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Recupère le données
		String mail = request.getParameter("mail");
		String reponse = request.getParameter("reponse");
		
		//On verifie la reponse est bonne
		try {
			
			if(userMetier.checkResponse(reponse, mail)) {
				
				
				System.out.println("Bonne réponse");
				User user = userMetier.findByEmail(mail);
				
				//On démarre une session puis on dirige vers profile
				HttpSession session = request.getSession();
				session.setAttribute("nom", user.getNom());
				session.setAttribute("prenom", user.getPrenom());
				session.setAttribute("mail", user.getEmail());
				
				response.sendRedirect("/projet_final/profil");
				
			} else {
				System.out.println("Réponse incorrecte");
				request.getRequestDispatcher("/user/login.jsp").forward(request, response);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Erreur dans le serveur");
		}
		
		
		
	}
	
}
