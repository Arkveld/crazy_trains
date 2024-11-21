package fr.org.projetfinal.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name ="/Logout")
public class Logout extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("user") == null){
			response.sendRedirect("/projet_final/login");
		 }
		session.removeAttribute("user");
		session.invalidate();
		request.getRequestDispatcher("user/logout.jsp").forward(request, response);
		/*HttpSession session = request.getSession(false);
		session.removeAttribute("user");
		session.setMaxInactiveInterval(60);
		session.invalidate();
		response.sendRedirect("/projet_final/login");
		System.out.println("Déconnexion");
		return;**/
		
	}
	
	

	

}
