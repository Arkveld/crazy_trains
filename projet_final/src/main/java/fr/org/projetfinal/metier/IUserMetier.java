package fr.org.projetfinal.metier;

import fr.org.projetfinal.model.User;

public interface IUserMetier {
	
	//Inscription
	public User register(User user) throws Exception;
	
	//Vérification des inputs
	public boolean verifyInput(String regex, String value);
	
	//Rechercher un user selon son mail
	public User findByEmail(String email) throws Exception;
	
	//Login
	public boolean login(String mail, String password) throws Exception;
	//Logout
	

}
