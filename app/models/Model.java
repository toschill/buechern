package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.mindrot.jbcrypt.BCrypt;

import play.db.DB;

public class Model extends StaticObservable{
	
	private static Connection connection = DB.getConnection();
	
	private static ArrayList <Book> BookList = new ArrayList<Book>();
	private static ArrayList <User> UserList = new ArrayList<User>();
	private static int bookNumber = 0;
	
	private static User activUser = new User();

	public Model(){
		boolean DBexists;
		try {
			PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM Books");
			PreparedStatement pstmt2 = connection.prepareStatement("SELECT * FROM Users");
			PreparedStatement pstmt3 = connection.prepareStatement("SELECT * FROM Status");
			pstmt.execute();
			pstmt2.execute();
			pstmt3.execute();
			DBexists=true;
		} catch (SQLException e) {
			DBexists = false;
			e.printStackTrace();
		}
		
		if(!DBexists){
			try {
				PreparedStatement pstmt = connection.prepareStatement("CREATE TABLE Books("+
						"BookId INTEGER PRIMARY KEY AUTOINCREMENT,"+ 
						"BookName VARCHAR2(255) NOT NULL,"+
						"Author VARCHAR2(255) NOT NULL,"+
						"Prof VARCHAR2(255),"+
					//	"RelDate DATE,"+
						"Layer VARCHAR2(255),"+
						"Condition  VARCHAR2(255) NOT NULL,"+
						"ISBN  VARCHAR2(255),"+
						"Price  VARCHAR2(255) NOT NULL,"+
						"State INTEGER(10) NOT NULL,"+
						"Buyer INTEGER(10),"+
						"Seller INTEGER(10) NOT NULL,"+
						"FOREIGN KEY (State) REFERENCES Sate(StateId),"+
						"FOREIGN KEY (Buyer) REFERENCES User(UserId),"+
						"FOREIGN KEY (Seller) REFERENCES Sate(UserId)");
				PreparedStatement pstmt2 = connection.prepareStatement(
						"CREATE TABLE Users("+
						"UserId INTEGER PRIMARY KEY AUTOINCREMENT,"+ 
						"FirstName VARCHAR2(255) NOT NULL,"+ 
						"SecondName VARCHAR2(255),"+ 
						"Email VARCHAR2(255) NOT NULL,"+ 
						"Password VARCHAR2(255) NOT NULL");
				PreparedStatement pstmt3 = connection.prepareStatement(
						"CREATE TABLE Status("+
						"StateId INTEGER PRIMARY KEY AUTOINCREMENT,"+
						"State VARCHAR2(255) NOT NULL");
				pstmt.executeUpdate();
				pstmt2.executeUpdate();
				pstmt3.executeUpdate();
				System.out.println("Model Konstruktor: DB wurde neu erzeugt");
				
				//Add Dummy User and Book
				
				User dummyUser = new User();
				dummyUser.setEmail("dummy@dummy.de");
				dummyUser.setFirstName("Dummy");
				dummyUser.setPassword(BCrypt.hashpw("dummy", BCrypt.gensalt()));
				
				addUser(dummyUser);
				Book dummyBook = new Book();
				dummyBook.setAuther("");
				dummyBook.setBookName("");
				dummyBook.setCondition("");
				dummyBook.setISBN("");
				dummyBook.setPrice("");
				dummyBook.setLayer("");
				dummyBook.setId(getBookNumber());
				setBookNumber(+1);
				dummyBook.setUser(dummyUser);
				
				addBook(dummyBook);
				System.out.println("Model Konstruktor: DummyDaten wurde neu erzeugt");
				
			} catch (SQLException e) {
				System.out.println("Model Konstruktor: Fehler beim erzeugen der DB");
				e.printStackTrace();
			}
		}
	}
	
	public static ArrayList <Book> getBookList() {
		try {
			PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM Books ORDER BY BookId DESC");
			BookList=doBookResult(pstmt.executeQuery());
		}catch (SQLException e) {
			System.out.println("Fehler beim holen der Bücher");
			e.printStackTrace();
		}
		
		return BookList;
	}
	
	public static User findUser(int id){
		for(User user :UserList){
			if(user.getId()==id){
				return user;
			}
		}
		return null;
	}

	public void setBookList(ArrayList <Book> bookList) {
		BookList = bookList;
	}

	public static ArrayList <User> getUserList() {
		ArrayList<User> users = new ArrayList<User>();
		try{
			PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM Users");
			ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					User user = new User();
					user.setId(rs.getInt("UserId"));
					user.setFirstName(rs.getString("FirstName"));
					user.setSecoundName(rs.getString("SecondName"));
					user.setEmail(rs.getString("Email"));
					user.setPassword(rs.getString("Password"));
					System.out.println("User: " +user.getFirstName());
					users.add(user);
				}
		}catch(SQLException e){
			System.out.println("Fehler beim holen der User");
			e.printStackTrace();
		}
		//doppelt mit Fabi anpassen
		UserList=users;
		return UserList;
	}
	
	public static void deleteAllUser(){
		try{
			//alle Benutzer in DB Löschen 
			PreparedStatement pstmtDelete = connection.prepareStatement("DELETE FROM Users");
			pstmtDelete.executeUpdate();
			System.out.println("Delete User OK!");
		}catch(SQLException e){
			System.out.println("Fehler beim löschen der User");
			e.printStackTrace();
		}
		
	}
	
	public static void setUserList(ArrayList <User> userList) {
		try{
			//alle Benutzer in DB Löschen 
			PreparedStatement pstmtDelete = connection.prepareStatement("DELETE FROM Users");
			pstmtDelete.executeUpdate();
		}catch(SQLException e){
			System.out.println("Fehler beim löschen der User");
			e.printStackTrace();
		}
		
		
		for(User user : userList){
			try{
				System.out.println("Schreibe User: "+user.getFirstName());

				PreparedStatement pstmt = connection.prepareStatement("INSERT INTO Users (FirstName , SecondName , Email , Password)"
						+ "VALUES (?, ?, ?, ?)");
				pstmt.setString(1, user.getFirstName());
				pstmt.setString(2, user.getSecoundName());
				pstmt.setString(3, user.getEmail());
				pstmt.setString(4, user.getPassword());
				pstmt.executeUpdate();
			}catch(SQLException e){
				System.out.println("Fehler beim schreiben des Users: "+ user.getFirstName());
				e.printStackTrace();
			}
		}
		UserList=userList;
	}
	
	public static void addUser(User user){
		//UserList hinzufuegen
		UserList.add(user);
		//und in DB schreiben
		try{
			System.out.println("Schreibe User: "+user.getFirstName());
			PreparedStatement pstmt = connection.prepareStatement("INSERT INTO Users (FirstName , SecondName , Email , Password)"
					+ "VALUES (?, ?, ?, ?)");
			pstmt.setString(1, user.getFirstName());
			pstmt.setString(2, user.getSecoundName());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getPassword());
			pstmt.executeUpdate();
		//	Model.schreibeStatus("Wir haben einen neuen Benutzer: " +user.getFirstName());
			notifyObservers(user);
		}catch(SQLException e){
			System.out.println("Fehler beim schreiben des Users: "+ user.getFirstName());
			e.printStackTrace();
		}
	}

	
	public static void addBook(Book book){
		//UserList hinzufuegen
		BookList.add(book);
		//und in DB schreiben
		try{
			PreparedStatement pstmt = connection.prepareStatement("INSERT INTO Books (BookName, Author, Prof, Layer, Condition, ISBN, Price, State,Seller)"
			+"VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)");
			pstmt.setString(1, book.getBookName());
			pstmt.setString(2, book.getAuther());
			pstmt.setString(3, book.getProf());
			//pstmt.setDate(4, );
			pstmt.setString(4, book.getLayer());
			pstmt.setString(5, book.getCondition());
			pstmt.setString(6, book.getISBN());
			pstmt.setString(7, book.getPrice());
			pstmt.setInt(8, book.getStatus());
			//pstmt.setInt(10, book.getBuyer().getId());
			pstmt.setInt(9, book.getUser().getId());
			System.out.println("DAVOR");
			pstmt.executeUpdate();
	//		Model.schreibeStatus("Es wurde ein neues Buch erstellt: " +book.getBookName());
			System.out.println("Model.addBook:Schreibe Buch: " + book.getBookName());
			notifyObservers(book);
		}catch(SQLException e){
			System.out.println("Fehler beim schreiben des Buches: "+ book.getBookName());
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Book> getSellerBooks(User user){
		try{
			PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM Books WHERE SellerId=?");
			pstmt.setInt(1, user.getId());
			return doBookResult(pstmt.executeQuery());
		}
		catch(SQLException e){
			System.out.println("Error find Seller Book");
			e.printStackTrace();
			return null;
		}
	}
	
	public static ArrayList<Book> getBooks(int status){
		try{
			PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM Books WHERE State=?");
			pstmt.setInt(1, status);
			return doBookResult(pstmt.executeQuery());
		}
		
		catch(SQLException e){
			System.out.println("Error find Seller Book");
			e.printStackTrace();
			return null;
		}
	}
	
	public static ArrayList<Book> getBuyerBooks(User user){
		try{
			PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM Books WHERE BuyerId=?");
			pstmt.setInt(1, user.getId());
			return doBookResult(pstmt.executeQuery());
		}
		catch(SQLException e){
			System.out.println("Error find Seller Book");
			e.printStackTrace();
			return null;
		}
	}
	
	public static void buyBook(User user, Book book){
		try{
			PreparedStatement pstmt = connection.prepareStatement("UPDATE Books SET Buyer=?, State=? WHERE BookId=?");
			pstmt.setInt(1, user.getId());
			pstmt.setInt(2, 1);
			pstmt.setInt(3, book.getId());
			pstmt.executeUpdate();
		}
		catch(SQLException e){
			System.out.println("Error Buy Book");
			e.printStackTrace();
		}
		
	}
	public static void changePassword(String newPass, User user){
		try{
			PreparedStatement pstmt = connection.prepareStatement("UPDATE Users SET Password=? WHERE UserId=?");
			pstmt.setString(1, newPass);
			pstmt.setInt(2, user.getId());
			pstmt.executeUpdate();
		}
		catch(SQLException e){
			System.out.println("Error changePassword");
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Book> doBookResult(ResultSet rs) throws SQLException{
		ArrayList<Book> books = new ArrayList<Book>();
		while(rs.next()){
			Book book = new Book();
			book.setId(rs.getInt("BookId"));
			book.setBookName(rs.getString("BookName"));
			book.setAuther(rs.getString("Author"));
			book.setProf(rs.getString("Prof"));
			book.setDate(null);
			book.setLayer(rs.getString("Layer"));
			book.setCondition(rs.getString("Condition"));
			book.setISBN(rs.getString("ISBN"));
			book.setPrice(rs.getString("Price"));
			book.setStatus(rs.getInt("State"));
			book.setBuyer(findUser(rs.getInt("Buyer")));
			book.setUser(findUser(rs.getInt("Seller")));
			books.add(book);
			System.out.println("Found Book: "+ book.getBookName());
		}
		return books;
	}
	
	
	public static void deleteAllBooks(){
		//BookList 
		BookList.clear();
		//delete all Books
		try{
			System.out.println("Lösche alle Bücher!");
			PreparedStatement pstmt = connection.prepareStatement("DELETE * FROM Books");
			pstmt.executeUpdate();
		}catch(SQLException e){
			System.out.println("Fehler beim löschen der Bücher!");
			e.printStackTrace();
		}
		
	}
	
	public static void deleteBook(Book book){
		if(book==null){
			return;
		}
		//UserList hinzufuegen
		BookList.remove(book);
		//und in DB schreiben
		try{
			System.out.println("Lösche Buch: "+book.getBookName());
			PreparedStatement pstmt = connection.prepareStatement("DELETE FROM Books WHERE BookId = ?");
			pstmt.setInt(1, book.getId());
			pstmt.executeUpdate();
		}catch(SQLException e){
			System.out.println("Fehler beim löschen des Buches: "+ book.getBookName());
			e.printStackTrace();
		}
	}
	
	public static void schreibeStatus(String status){
		try {
			PreparedStatement pstmt = connection.prepareStatement("UPDATE Status SET State=? WHERE StateId=1");
			pstmt.setString(1, status);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Fehler beim Setzten des Status: "+ status);
			e.printStackTrace();
		}
	}

	public static String leseStatus(){
		String status=null;
		try {
			PreparedStatement pstmt = connection.prepareStatement("SELECT State FROM Status WHERE StateId=1");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				status = rs.getString("State");
			}
		} catch (SQLException e) {
			System.out.println("Fehler beim lesen des Status");
			e.printStackTrace();
		}
		return status;
	}
	
	public static User getActivUser() {
		return activUser;
	}

	public static void setActivUser(User activUser) {
		Model.activUser = activUser;
	}

	public static int getBookNumber() {
		return bookNumber;
	}

	public static void setBookNumber(int bookNumber) {
		Model.bookNumber = bookNumber;
	}
	
}
