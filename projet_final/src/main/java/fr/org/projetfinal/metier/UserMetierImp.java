package fr.org.projetfinal.metier;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.org.projetfinal.model.User;

public class UserMetierImp implements IUserMetier {

	@Override
	public void register(User user) {
		// TODO Auto-generated method stub
		
	}
	
	//Vérifie le format des données
	public boolean verifyInput(String regex, String value) {
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(value);
		
		return matcher.find();
		
	}

}
