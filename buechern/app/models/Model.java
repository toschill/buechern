package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import play.db.DB;

public class Model {
	
	private static Connection connection = DB.getConnection();
	
	private static ArrayList <Book> BookList = new ArrayList<Book>();
	private static ArrayList <User> UserList = new ArrayList<User>();
	private static int bookNumber = 0;
	
	private static User activUser = new User();

	public static ArrayList <Book> getBookList() {
		try {
			PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM Books");
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
					user.setPassword(rs.getInt("Password"));
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
				pstmt.setInt(4, user.getPassword());
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
			pstmt.setInt(4, user.getPassword());
			pstmt.executeUpdate();
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
			System.out.println("Schreibe Buch: "+book.getBookName());
			PreparedStatement pstmt = connection.prepareStatement("INSERT INTO Books (BookName, Author, Prof , RelDate, Layer, Condition, ISBN, Price, State,Buyer,Seller)"
			+"VALUES (?, ?, ?, ?, ?, ?, ?, ?,?,?,?)");
			pstmt.setString(1, book.getBookName());
			pstmt.setString(2, book.getAuther());
			pstmt.setString(3, book.getProf());
			//pstmt.setDate(4, );
			pstmt.setString(5, book.getLayer());
			pstmt.setString(6, book.getCondition());
			pstmt.setString(7, book.getISBN());
			pstmt.setString(8, book.getPrice());
			pstmt.setInt(9, book.getStatus());
			//pstmt.setInt(10, book.getBuyer().getId());
			pstmt.setInt(11, book.getUser().getId());
			
			pstmt.executeUpdate();
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
