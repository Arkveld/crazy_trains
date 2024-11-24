package fr.org.projetfinal.dao.Categorie;

import java.util.List;

import fr.org.projetfinal.model.Categorie;

public interface ICategorieDao {

	public List<Categorie> getAllCategories() throws Exception;
}
