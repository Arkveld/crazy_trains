package fr.org.projetfinal.controller.User;

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
	private String messageError;
	
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
		
		request.getRequestDispatcher("/pages/register.jsp").forward(request, response);
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
		boolean inputPassword = metier.verifyInput("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*\\W)(?!.* ).{12,16}$", password);
		
		if(!inputNom) {
			messageError = "Nom invalide";
			request.setAttribute("messageError", messageError);
			response.sendRedirect("/projet_final/register");
		}
		
		if(!inputPrenom) {
			messageError = "Prénom invalide";
			request.setAttribute("messageError", messageError);
			response.sendRedirect("/projet_final/register");
		}
		
		if(!inputMail) {
			messageError = "Mail invalide";
			request.setAttribute("messageError", messageError);
			response.sendRedirect("/projet_final/register");
		}
		
		if(!inputPassword) {
			messageError = "Password invalide";
			request.setAttribute("messageError", messageError);
			response.sendRedirect("/projet_final/register");
		}
		
		//Création d'un user
		User user = new User();
		user.setNom(nom);
		user.setPrenom(prenom);
		user.setEmail(mail);
		user.setPassword(password);
		user.setRole(role);
		user.setQuestion_id(questionId);
		user.setReponse(reponse);
		
		//Inscription (Envoi de l'user vers la BDD)
		try {
			metier.register(user);
			response.sendRedirect("/projet_final/success");
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Erreur dans le serveur");
		}
	}
}
