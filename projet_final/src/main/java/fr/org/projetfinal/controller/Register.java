package fr.org.projetfinal.controller;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "/Register")
public class Register extends HttpServlet {
	
	
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
		Pattern pattern = Pattern.compile("^[a-zA-Z]{1,32}$");
		Matcher matcher = pattern.matcher(nom);
		boolean matchFound = matcher.find();
		System.out.println(matchFound);
		System.out.println("Nom: " + nom);
		
		
		System.out.println("Prénom: " + prenom);
		System.out.println("Mail: " + mail);
		System.out.println("Password: " + password);
		System.out.println("Role: " + role);
		
	}

}
