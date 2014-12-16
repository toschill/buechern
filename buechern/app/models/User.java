package models;

import java.util.ArrayList;

public class User {
	private int id; 
	private String FirstName; 
	private String SecoundName;
	private String Email;
	private Integer Password;

	private static ArrayList <Book> UserBook = new ArrayList<Book>();

	
	
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getSecoundName() {
		return SecoundName;
	}
	public void setSecoundName(String secoundName) {
		SecoundName = secoundName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public int getPassword() {
		return Password;
	}
	public void setPassword(int password) {
		Password = password;
	}
	public ArrayList <Book> getUserBook() {
		return UserBook;
	}
	public static void setUserBook(ArrayList <Book> userBook) {
		UserBook = userBook;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	 
}
