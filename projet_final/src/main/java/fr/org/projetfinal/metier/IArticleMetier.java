package fr.org.projetfinal.metier;



import javax.servlet.http.Part;

import fr.org.projetfinal.model.Article;

public interface IArticleMetier {
	
	public Article saveArticle(Article article) throws Exception;
	//Récupere le nom du fichier
	public String getFileName(Part part);
	//Vérifie le format du fichier
	public boolean verifyFormatFile(String filename);
	//Upload du fichier
	public void uploadFile(Part part);
		


}
