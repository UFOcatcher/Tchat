package bean;

import java.sql.Timestamp;

public class Message {

	private int id;
	private String text;
	private int auteur;
	private Timestamp date;
	
	public Message() {
		this.id = 0;
		this.text = "";
		this.auteur = 0;
		this.date = null;
	}
	
	public Message(int id, String text, int auteur, Timestamp date) {
		this.id = id;
		this.text = text;
		this.auteur = auteur;
		this.date = date;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return this.text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getAuteur() {
		return this.auteur;
	}
	public void setAuteur(int auteur) {
		this.auteur = auteur;
	}
	public Timestamp getDate() {
		return this.date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}	
	
	
	
}
