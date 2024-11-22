package fr.org.projetfinal.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.org.projetfinal.model.User;

@WebServlet(name = "/Admin")
public class Admin extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		//On récupère l'user dans la session
		User user = (User) session.getAttribute("user");
		if (user.getRole().equals("admin")) {
			request.getRequestDispatcher("admin/admin.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("user/login.jsp").forward(request, response);
		}
		
		
	}
}
