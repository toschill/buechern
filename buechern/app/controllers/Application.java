package controllers;

import java.util.ArrayList;








import models.Book;
import models.User;
import play.*;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {
	
	
	static ArrayList <Book> BookList = new ArrayList<Book>();
	static ArrayList <User> UserList = new ArrayList<User>();
	static Boolean isLogged = false;
	
    public static Result index() {
        return ok(index.render());
    }
    public static Result  profile() {
    	if(isLogged == true){
	    	if(BookList.isEmpty()){
	    		
	    		return ok(profile.render(BookList,UserList));
	    		
	    	}else{
	    		
	    		return ok(profile.render(BookList,UserList));
	    	}
    	}else{
    		return ok(registrierung.render());	
    	}
    	
		
	}
    
    public static Result changeUserData(){
    	return ok(userDatenAendern.render());
    }
    
	public static Result verkaufen(){
		return ok(verkaufen.render());
   }
	
	public static Result einkaufen(){
		return ok(einkaufen.render(BookList));
   }
	
	public static Result registrierung(){
		return ok(registrierung.render());
	}
	
	public static Result addBook(String Booktitel, 
								 String Autor, 
								 String Erscheinungsjahr, 
								 String ISBN , 
								 String Auflage, 
								 String Zustand, 
								 String Preis, 
								 String BoolFestpreis){
	    Book newBook = new Book();
		
		
		newBook.setBookName(Booktitel);
		newBook.setAuther(Autor);
		newBook.setDate(Erscheinungsjahr);
		newBook.setISBN(ISBN);
		newBook.setLayer(Auflage);
		newBook.setCondition(Zustand);
		newBook.setPrice(Preis);
		
		BookList.add(newBook);
		
		return ok(profile.render(BookList,UserList));
	}

	
	public static Result deleteBook(String deleteBookISBN){
		Book deleteBook=null;
		for(Book book: BookList){
			if(book.getISBN().equals(deleteBookISBN)){
				deleteBook=book;
			}
		}
		BookList.remove(deleteBook);
		return ok(profile.render(BookList,UserList));
	}
	
	public static Result addUser(String FirstName, 							  
								  String Email){
		User newUser = new User();
		
		newUser.setFirstName(FirstName);
		newUser.setEmail(Email);
		
		UserList.add(newUser);
		isLogged = true;
		return ok(profile.render(BookList,UserList));
		
	}
	
}
