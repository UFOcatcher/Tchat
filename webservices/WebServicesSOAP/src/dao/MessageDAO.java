package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import bean.Message;

public class MessageDAO extends DAO<Message>{
	public MessageDAO(Connection conn) {
		super(conn);
	}

	public void create(Message obj) {
		try {
			this.connect
				.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
				.executeUpdate("INSERT INTO USER (text, auteur) VALUES (" + obj.getText() + "," + new Timestamp(System.currentTimeMillis()) + ")");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(Message obj) {
		try {
			this.connect
				.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
				.executeUpdate("DELETE FROM USER WHERE id = " + obj.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(Message obj) {
		try {
			this.connect
				.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
				.executeUpdate("INSERT INTO MESSAGE (text, auteur, date) VALUES (" + obj.getText() + "," + obj.getAuteur() + "," + obj.getDate() + ") WHERE id = " + obj.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Message find(int id) {
		Message message = new Message();
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM message WHERE id = " + id);
			if (result.first())
				message = new Message(id, result.getString("text"), result.getInt("id_auteur"), result.getTimestamp("date"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return message;
	}
	
	public List<Message> findAll() {
		List<Message> messages = new ArrayList<Message>();
		try {
			ResultSet results = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM user");
			while(results.next())
				messages.add(new Message(results.getInt("id"), results.getString("text"), results.getInt("id_auteur"), results.getTimestamp("date")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return messages;
	}
	
	public List<Message> customQuery(String query) {
		List<Message> messages = new ArrayList<Message>();
		try {
			ResultSet results = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery(query);
			while(results.next())
				messages.add(new Message(results.getInt("id"), results.getString("text"), results.getInt("id_auteur"), results.getTimestamp("date")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return messages;
	}
}
