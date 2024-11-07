package fr.org.projetfinal.metier;

import fr.org.projetfinal.model.User;

public interface IUserMetier {
	
	//Inscription
	public void register(User user);
	
	//Vérification des inputs
	public boolean verifyInput(String regex, String value);
	
	//Login
	
	//Logout
	

}
