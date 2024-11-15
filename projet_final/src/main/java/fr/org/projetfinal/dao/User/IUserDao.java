package fr.org.projetfinal.dao.User;

import fr.org.projetfinal.model.User;

public interface IUserDao {
	
	public User addUser(User user) throws Exception;
	public User getUserByEmail(String mail) throws Exception;

}
