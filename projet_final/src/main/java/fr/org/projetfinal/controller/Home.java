package fr.org.projetfinal.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "/Home")
public class Home extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest requset, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = requset.getSession(false);
		response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
		requset.getRequestDispatcher("/index.jsp").forward(requset, response);
	}

}
