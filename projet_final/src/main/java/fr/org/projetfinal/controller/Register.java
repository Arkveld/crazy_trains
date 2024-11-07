package fr.org.projetfinal.controller;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.org.projetfinal.metier.IUserMetier;
import fr.org.projetfinal.metier.UserMetierImp;

@WebServlet(name = "/Register")
public class Register extends HttpServlet {
	
	private IUserMetier metier;
	
	@Override
	public void init() throws ServletException {
		metier = new UserMetierImp();
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("register.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Récupération de données du formulaire
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String mail = request.getParameter("mail");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		
		//Vérification du format des données (REGEX java)
		boolean inputNom = metier.verifyInput("^[a-zA-Z]{1,32}$", nom);
		boolean inputPrenom = metier.verifyInput("^[a-zA-Z]{1,32}$", prenom);
		boolean inputMail = metier.verifyInput("^[a-z]{1,32}\\.[a-zA-z]{1,32}\\@[a-z]{1,10}\\.[a-z]{1,3}$", mail);
		
		if(!inputNom) {
			System.out.println("Veuillez respecter le format");
		}
		
		if(!inputPrenom) {
			System.out.println("Veuillez respecter le format");
		}
		
		if(!inputMail) {
			System.out.println("Mail invalide");
		}
		
		
		
		
		/*Pattern pattern = Pattern.compile("");
		Matcher matcher = pattern.matcher(nom);
		boolean matchFound = matcher.find();
		System.out.println(matchFound);*/
		System.out.println("Nom: " + nom);
		
		
		
		
	}

}
