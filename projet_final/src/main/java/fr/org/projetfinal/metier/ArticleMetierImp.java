package fr.org.projetfinal.metier;

import javax.servlet.http.Part;

import fr.org.projetfinal.dao.Article.ArticleDaoImp;
import fr.org.projetfinal.dao.Article.IArticleDao;
import fr.org.projetfinal.model.Article;

public class ArticleMetierImp implements IArticleMetier {
	
	private IArticleDao articleDao;

	@Override
	public Article saveArticle(Article article) throws Exception {
		this.articleDao = new ArticleDaoImp();
		return articleDao.addArticle(article);
	}

	@Override
	public String getFileName(Part part) {
		//On récupère le content-disposition
		String contentDisposition = part.getHeader("content-disposition");
		
		if(!contentDisposition.contains("filename=")) {
			return null;
		}
		//Extraction du nom
		int beginIndex = contentDisposition.indexOf("filename") + 10;
		int endIndex = contentDisposition.length() - 1;
		
		return contentDisposition.substring(beginIndex, endIndex);
	}

	@Override
	public boolean verifyFormatFile(String filename) {
		if(!filename.contains(".png") || !filename.contains(".jpg")) {
			return false;
		}
		return true;
	}

	@Override
	public void uploadFile(Part part) {
		
		try {
			String filename = getFileName(part);
			part.write(filename);
			System.out.println("Upload réussi");
				
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Échec de l'upload");
		}
		
		
	}
	
	

}
