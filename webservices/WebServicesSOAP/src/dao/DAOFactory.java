package dao;

import java.sql.Connection;

public class DAOFactory {
	protected static final Connection conn = Connexion.getInstance();

	public static DAO getUserDAO() {
		return new UserDAO(conn);	
	}
	
	public static DAO getMessageDAO() {
		return new MessageDAO(conn);
	}
}
