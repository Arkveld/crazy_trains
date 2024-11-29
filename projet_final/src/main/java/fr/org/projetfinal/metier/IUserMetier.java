package fr.org.projetfinal.metier;

import java.util.List;

import fr.org.projetfinal.model.User;

public interface IUserMetier {
	
	//Inscription
	public User register(User user) throws Exception;
	
	//Vérification des inputs
	public boolean verifyInput(String regex, String value);
	
	//Rechercher un user selon son mail
	public User findByEmail(String email) throws Exception;
	
	//Obtenir tous les utilisateurs
	public List<User> find() throws Exception;
	
	//Obtenir un user selon son id
	public User findOne(int id) throws Exception;
	
	//Modifier un user
	public void updateUser(User user, int id) throws Exception;
	
	//Supprimer un user
	public void deleteUser(int id) throws Exception;
	//Login
	public boolean login(String mail, String password) throws Exception;
	
	//Verification de la reponse
	public boolean checkResponse(String reponse, String mail) throws Exception;
	
	//Logout
	

}
