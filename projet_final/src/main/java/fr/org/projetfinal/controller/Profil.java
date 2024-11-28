package fr.org.projetfinal.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name ="/Profil")
public class Profil extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
		HttpSession session = request.getSession(false);
		if(session.getAttribute("user") == null){
			response.sendRedirect("/projet_final/login");
		 } else {
			 request.getRequestDispatcher("user/profil.jsp").forward(request, response);
		 }
		
		
		

	}

}
