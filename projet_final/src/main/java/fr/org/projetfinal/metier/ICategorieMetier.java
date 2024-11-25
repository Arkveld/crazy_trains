package fr.org.projetfinal.metier;

import java.util.List;

import fr.org.projetfinal.model.Categorie;

public interface ICategorieMetier {

	public List<Categorie> findAllCategories() throws Exception;
}
