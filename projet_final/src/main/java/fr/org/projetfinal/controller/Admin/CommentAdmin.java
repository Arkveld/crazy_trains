package fr.org.projetfinal.controller.Admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.org.projetfinal.metier.CommentaireMetierImp;
import fr.org.projetfinal.metier.ICommentaireMetier;
import fr.org.projetfinal.metier.IUserMetier;
import fr.org.projetfinal.metier.UserMetierImp;
import fr.org.projetfinal.model.Commentaire;
import fr.org.projetfinal.model.User;

@WebServlet(name ="/AdminComment")
public class CommentAdmin extends HttpServlet {

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
		//On récupère l'user dans la session
		User user = (User) session.getAttribute("user");
		if(!user.getRole().equals("admin")){
			response.sendRedirect("/projet_final/login");
		 } else {
			 
			//On récupère tous les users
			 try {
				 
				 List<Commentaire> comments = new ArrayList<Commentaire>();
				 comments = commentaireMetier.findAllComments();
				 request.setAttribute("comments", comments);
				 
			 } catch(Exception e) {
				 e.printStackTrace();
			 }
				
			 request.getRequestDispatcher("admin/adminComment.jsp").forward(request, response);
		}
	}

}
