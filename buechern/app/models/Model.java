package models;

import java.util.ArrayList;

public class Model {
	
	private static ArrayList <Book> BookList = new ArrayList<Book>();
	private static ArrayList <User> UserList = new ArrayList<User>();
	
	private static User activUser = new User();
	
	static User Peter = new User();
	static User Hans = new User();
	
	static Book EinXML = new Book();
	static Book Or =new Book();
	static Book GrJava = new Book();

	public static ArrayList <Book> getBookList() {
		return BookList;
	}

	public void setBookList(ArrayList <Book> bookList) {
		BookList = bookList;
	}

	public static ArrayList <User> getUserList() {
		return UserList;
	}

	public void setUserList(ArrayList <User> userList) {
		UserList = userList;
	}
	
	public static void addDummy(){
		
		Peter.setFirstName("Peter");
		Peter.setEmail("peter@web.de");
		Peter.setPassword("1234");
		
		
		Hans.setFirstName("Hans");
		Hans.setEmail("Hans@hansi.net");
		Hans.setPassword("0000");
		
		Peter.getUserBook().add(EinXML);
		Hans.getUserBook().add(Or);
		Peter.getUserBook().add(GrJava);
		
		EinXML.setBookName("Einstieg in XML");
		EinXML.setAuther("Helmut Vonhoegen");
		EinXML.setISBN("978-3-8362-1074-4");
		EinXML.setLayer("4");
		EinXML.setDate("2007");
		EinXML.setPrice("34,90");
		EinXML.setUser(Hans);
		
		Or.setBookName("Operation Research");
		Or.setAuther("Gert Heinrich");
		Or.setISBN("978-3-486-71696-2");
		Or.setLayer("2");
		Or.setDate("2013");
		Or.setPrice("20,50");
		Or.setUser(Peter);
		
		GrJava.setBookName("Grundkurs Java");
		GrJava.setAuther("Ratz");
		GrJava.setISBN("978-3-446-42663-4");
		GrJava.setLayer("6");
		GrJava.setDate("2011");
		GrJava.setPrice("34,90");
		GrJava.setUser(Peter);
	
		BookList.add(EinXML);
		BookList.add(Or);
		BookList.add(GrJava);
		
		UserList.add(Peter);
		UserList.add(Hans);
		
		
		
	}

	public static User getActivUser() {
		return activUser;
	}

	public static void setActivUser(User activUser) {
		Model.activUser = activUser;
	}

}
