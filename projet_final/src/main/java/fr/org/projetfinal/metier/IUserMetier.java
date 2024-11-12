package fr.org.projetfinal.metier;

import fr.org.projetfinal.model.User;

public interface IUserMetier {
	
	//Inscription
	public User register(User user) throws Exception;
	
	//Vérification des inputs
	public boolean verifyInput(String regex, String value);
	
	//Login
	
	//Logout
	

}
