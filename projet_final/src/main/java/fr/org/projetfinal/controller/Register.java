package fr.org.projetfinal.controller;

import java.io.IOException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.org.projetfinal.metier.IQuestionMetier;
import fr.org.projetfinal.metier.IUserMetier;
import fr.org.projetfinal.metier.QuestionMetierImp;
import fr.org.projetfinal.metier.UserMetierImp;
import fr.org.projetfinal.model.Question;
import fr.org.projetfinal.model.User;

@WebServlet(name = "/Register")
public class Register extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private IUserMetier metier;
	private IQuestionMetier questionMetier;
	
	@Override
	public void init() throws ServletException {
		metier = new UserMetierImp();
		questionMetier = new QuestionMetierImp();
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			
			List<Question> questions = questionMetier.findAllQuestion();
			request.setAttribute("questions", questions);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Erreur dans nos serveurs");
		}
		
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
		int questionId = Integer.parseInt(request.getParameter("question"));
		String reponse = request.getParameter("reponse");
		
		
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
		
		User user = new User();
		user.setNom(nom);
		user.setPrenom(prenom);
		user.setPassword(password);
		user.setRole(role);
		user.setQuestion_id(questionId);
		user.setReponse(reponse);
		
		System.out.println("Nom: " + user.getNom());
		System.out.println("Prénom: " + user.getPrenom());
		System.out.println("Mail:" + user.getEmail());
		System.out.println("Id question: " + user.getQuestion_id());
		System.out.println("Réponse: " + user.getReponse());
		System.out.println("Role:" + user.getRole());
		
		
		
		
	}

}
