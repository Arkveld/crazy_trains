package fr.org.projetfinal.controller.User;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.org.projetfinal.metier.IQuestionMetier;
import fr.org.projetfinal.metier.IUserMetier;
import fr.org.projetfinal.metier.QuestionMetierImp;
import fr.org.projetfinal.metier.UserMetierImp;
import fr.org.projetfinal.model.Question;
import fr.org.projetfinal.model.User;

public class UpdateProfil extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private IUserMetier userMetier;
	private IQuestionMetier questionMetier;
	private String messageError;
	
	@Override
	public void init() throws ServletException {
		userMetier = new UserMetierImp();
		questionMetier = new QuestionMetierImp();
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
		
		
		try {
			
			//Récupère user selon l'id
			User user = userMetier.findOne(id);
			
			//Récupère les question
			List<Question> questions = questionMetier.findAllQuestion();
			
			request.setAttribute("user", user);
			request.setAttribute("questions", questions);
			request.getRequestDispatcher("/pages/user/updateProfil.jsp").forward(request, response);
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//Récupération de données du formulaire
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String mail = request.getParameter("mail");
		int questionId = Integer.parseInt(request.getParameter("question"));
		String reponse = request.getParameter("reponse");
		int id = Integer.parseInt(request.getParameter("id"));
		
		//Vérification du format des données (REGEX java)
		boolean inputNom = userMetier.verifyInput("^[a-zA-Z]{1,32}$", nom);
		boolean inputPrenom = userMetier.verifyInput("^[a-zA-Z]{1,32}$", prenom);
		boolean inputMail = userMetier.verifyInput("^[a-z]{1,32}\\.[a-zA-z]{1,32}\\@[a-z]{1,10}\\.[a-z]{1,3}$", mail);
				
		if(!inputNom) {
			messageError = "Nom invalide";
			request.setAttribute("messageError", messageError);
			response.sendRedirect("/pages/user/updateProfil.jsp");
		}
				
		if(!inputPrenom) {
				messageError = "Prénom invalide";
				request.setAttribute("messageError", messageError);
				response.sendRedirect("/pages/user/updateProfil.jsp");
		}
				
		if(!inputMail) {
			messageError = "Mail invalide";
			request.setAttribute("messageError", messageError);
			response.sendRedirect("/pages/user/updateProfil.jsp");
		}
		
		//Création d'un user
		User user = new User();
		user.setNom(nom);
		user.setPrenom(prenom);
		user.setEmail(mail);
		user.setQuestion_id(questionId);
		user.setReponse(reponse);
		
		//Mise à jour du profil
		try {
			userMetier.updateUser(user, id);
			request.getRequestDispatcher("/pages/user/profil.jsp").forward(request, response);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
