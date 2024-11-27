package fr.org.projetfinal.dao.Categorie;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.org.projetfinal.bdd.MyConnectionSQL;
import fr.org.projetfinal.model.Categorie;

public class CategorieDaoImp implements ICategorieDao {
	
	private Connection connection;

	@Override
	public List<Categorie> getAllCategories() throws Exception {
		
		List<Categorie> categories = new ArrayList<Categorie>();
		
		this.connection = MyConnectionSQL.getInstance();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM category");
		
		while(resultSet.next()) {
			
			Categorie categorie = new Categorie();
			categorie.setId(resultSet.getInt("id"));
			categorie.setNom_categorie(resultSet.getString("nom_categorie"));
			
			categories.add(categorie);
		}
		
		//resultSet.close();
		//statement.close();
		//connection.close();
		
		return categories;
	}

}
