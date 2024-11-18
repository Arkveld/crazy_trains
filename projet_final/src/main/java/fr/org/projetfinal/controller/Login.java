package fr.org.projetfinal.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.org.projetfinal.metier.IUserMetier;
import fr.org.projetfinal.metier.UserMetierImp;
import fr.org.projetfinal.model.User;

@WebServlet(name= "/Login")
public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private IUserMetier userMetier;
	
	@Override
	public void init() throws ServletException {
		userMetier = new UserMetierImp();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/user/login.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mail = request.getParameter("mail");
		String password = request.getParameter("password");
		
		try {
			userMetier.login(mail, password);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
