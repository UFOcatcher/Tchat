package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
	
	private static Connection connection;
	
	private static String url = "http://localhost:3635/tchat/";
	private static String user = "root";
	private static String passwd = "toor";
	
	public static Connection getInstance() {
		if (connection == null) {
			try {
				connection = DriverManager.getConnection(url, user, passwd);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}

}
