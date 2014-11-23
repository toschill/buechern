package models;

public class User {
	private String FirstName; 
	private String SecoundName;
	private String Email;
	private String Password;
	private Book UserBook = new Book();
	
	
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
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public Book getUserBook() {
		return UserBook;
	}
	public void setUserBook(Book userBook) {
		UserBook = userBook;
	}
	 
}
