package fr.org.projetfinal.controller.Commentaire;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.org.projetfinal.metier.CommentaireMetierImp;
import fr.org.projetfinal.metier.ICommentaireMetier;

@WebServlet(name = "/DeleteComment")
public class DeleteComment extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ICommentaireMetier commentaireMetier;
	
	@Override
	public void init() throws ServletException {
		commentaireMetier = new CommentaireMetierImp();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
		
		if(session.getAttribute("user") == null) {
			response.sendRedirect("/projet_final/login");
		}
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		try {
			//commentaireMetier.delete(id);
			System.out.println(id);
			
		} catch(Exception e) {
			 e.printStackTrace();
		}
	}

}
