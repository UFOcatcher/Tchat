package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.User;

public class UserDAO extends DAO<User>{
	public UserDAO(Connection conn) {
		super(conn);
	}

	public void create(User obj) {
		try {
			this.connect
				.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
				.executeUpdate("INSERT INTO USER (name) VALUES (" + obj.getName() + ")");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(User obj) {
		try {
			this.connect
				.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
				.executeUpdate("DELETE FROM USER WHERE id = " + obj.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(User obj) {
		try {
			this.connect
				.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
				.executeUpdate("INSERT INTO USER (name) VALUES (" + obj.getName() + ") WHERE id = " + obj.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public User find(int id) {
		User user = new User();
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM user WHERE id = " + id);
			if (result.first())
				user = new User(id, result.getString("name"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public List<User> findAll() {
		List<User> users = new ArrayList<User>();
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM user");
			while(result.next())
				users.add(new User(result.getInt("id"), result.getString("name")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	public List<User> customQuery(String query) {
		List<User> users = new ArrayList<User>();
		try {
			ResultSet results = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery(query);
			while(results.next())
				users.add(new User(results.getInt("id"), results.getString("name")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
}
