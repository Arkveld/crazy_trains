package fr.org.projetfinal.metier;

import java.util.List;

import fr.org.projetfinal.dao.Categorie.CategorieDaoImp;
import fr.org.projetfinal.dao.Categorie.ICategorieDao;
import fr.org.projetfinal.model.Categorie;

public class CategorieMetierImp implements ICategorieMetier {

	private ICategorieDao categorieDao;
	@Override
	public List<Categorie> findAllCategories() throws Exception {
		this.categorieDao = new CategorieDaoImp();
		return categorieDao.getAllCategories();
	}
	

}
