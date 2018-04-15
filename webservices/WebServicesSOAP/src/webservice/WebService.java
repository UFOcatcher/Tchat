package webservice;
import java.util.Calendar;

import javax.jws.WebMethod;

import bean.Message;
import bean.User;
import dao.DAOFactory;

public class WebService {
	
	@WebMethod
	public String hello() {
		return "Hello !";
	}

	@WebMethod
	public void addUser(String name) {
		User user = new User(name);
		DAOFactory.getUserDAO().create(user);
	}
	
	@WebMethod
	public void deleteUser(int id) {
		//User user = (User) DAOFactory.getUserDAO().find(id);
		//DAOFactory.getUserDAO().delete(user);
	}
	
	@WebMethod
	public User[] listUsers() {
		return new User[]{new User()};
		//return DAOFactory.getUserDAO().findAll();
	}
	
	
	@WebMethod
	public Message[] getMessagesSince(Calendar date, int auteur) {
		return new Message[]{new Message()};
		//return DAOFactory.getMessageDAO().customQuery("SELECT * FROM message WHERE date > " + date + " AND id_auteur = " + auteur);
	}
	
	@WebMethod
	public Message[] getAllMessages(int auteur) {
		return new Message[]{new Message()};
		//return null;
	}
	
}
