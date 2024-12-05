package fr.org.projetfinal.metier;



import java.util.List;

import javax.servlet.http.Part;

import fr.org.projetfinal.model.Article;

public interface IArticleMetier {
	
	public Article saveArticle(Article article) throws Exception;
	public List<Article> findArticles() throws Exception;
	public Article findOne(int id) throws Exception;
	public List<Article> findArticlesByCategorie(int id) throws Exception;
	public void update(Article article, int id) throws Exception;
	public void delete(int id) throws Exception;
	//Récupere le nom du fichier
	public String getFileName(Part part);
	//Vérifie le format du fichier
	public boolean verifyFormatFile(String filename);
	//Upload du fichier
	public void uploadFile(Part part);
}
