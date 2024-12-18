package fr.org.projetfinal.metier;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.org.projetfinal.dao.User.IUserDao;
import fr.org.projetfinal.dao.User.UserDaoImp;
import fr.org.projetfinal.model.User;

public class UserMetierImp implements IUserMetier {
	
	private IUserDao userDao;

	@Override
	//Enregistrement d'un user
	public User register(User user) throws Exception {
		this.userDao = new UserDaoImp();
		return userDao.addUser(user);
		
	}
	
	//Vérifie le format des données
	public boolean verifyInput(String regex, String value) {
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(value);
		
		return matcher.find();
		
	}
	
	//Authentification
	public boolean login(String mail, String password) throws Exception {
		
		User user;
		this.userDao = new UserDaoImp();
		
		try {
			
			user = userDao.getUserByEmail(mail);
			if (user != null) {
				
				if(password.equals(user.getPassword())) {
					System.out.println("Mot de passe identique");
					return true;
				}
				
			}
			
			return false;
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erreur dans nos serveurs");
		}
		
		return false;
	}

	//Retourne un user selon son mail
	public User findByEmail(String email) throws Exception {
		this.userDao = new UserDaoImp();
		return userDao.getUserByEmail(email);

	}

	@Override
	public boolean checkResponse(String reponse, String mail) throws Exception {
		this.userDao = new UserDaoImp();
		User user = userDao.getUserByEmail(mail);
		
		//Vérifie la reponse
		if(reponse.equalsIgnoreCase(user.getReponse())) {
			return true;
		}
		return false;
	}
	
	
	
	
	

}
