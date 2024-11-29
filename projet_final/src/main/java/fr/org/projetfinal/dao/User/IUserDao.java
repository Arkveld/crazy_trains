package fr.org.projetfinal.dao.User;

import java.util.List;

import fr.org.projetfinal.model.User;

public interface IUserDao {
	
	public User addUser(User user) throws Exception;
	public User getUserByEmail(String mail) throws Exception;
	public User getUserById(int id) throws Exception;
	public List<User> getUsers() throws Exception;
	public void update(User user,int id) throws Exception;
	public void delete(int id) throws Exception;

}
