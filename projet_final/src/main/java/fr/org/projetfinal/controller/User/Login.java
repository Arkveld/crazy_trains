package fr.org.projetfinal.controller.User;

import java.io.IOException;

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

@WebServlet(name= "/Login")
public class Login extends HttpServlet {

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
		request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mail = request.getParameter("mail");
		String password = request.getParameter("password");
		
		try {
			
			Boolean login = userMetier.login(mail, password);
			if (login) {
				
				//On récupère l'utilisateur selon le mail
				User user = userMetier.findByEmail(mail);
		
				//On récupère la question de cet utilisateur
				Question question = questionMetier.findQuestionById(user.getQuestion_id());
				
				//Puis on envoie vers la  page
				request.setAttribute("user", user);
				request.setAttribute("question", question);
				
				request.getRequestDispatcher("/pages/user/question.jsp").forward(request, response);
			} else {
				messageError = "Mail ou mot de passe incorrecte";
				request.setAttribute("messageError", messageError);
				request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
