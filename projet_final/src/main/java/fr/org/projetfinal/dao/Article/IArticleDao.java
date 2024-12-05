package fr.org.projetfinal.dao.Article;

import java.util.List;

import fr.org.projetfinal.model.Article;

public interface IArticleDao {

	public Article addArticle(Article article) throws Exception;
	public List<Article> getArticles() throws Exception;
	public Article getArticleById(int id) throws Exception;
	public void updateArticle(Article article,int id) throws Exception;
	public void deleteArticle(int id) throws Exception;
	public List<Article> getArticleByCategorie(int id) throws Exception;
}
