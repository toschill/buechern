package controllers;

import java.util.ArrayList;

import models.Book;
import models.Model;
import models.User;
import play.*;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {
	
	
	
	
	static Boolean isLogged = false;
	static Boolean dummySet = false;
	
	
    public static Result index() {
    	//load dummy objects 
    	if(dummySet == false){
    		Model.addDummy();
    		
    		dummySet=true;
    	}
    	
        return ok(index.render());
    }
    
    public static Result  profile() {
    	if(isLogged == true){
    		
	    	if(Model.getBookList().isEmpty()){
	    
	    		return ok(profile.render(Model.getActivUser().getUserBook(),Model.getActivUser()));
	    		
	    	}else{
	    		
	    		return ok(profile.render(Model.getActivUser().getUserBook(),Model.getActivUser()));
	    	}
    	}else{
    		
    		return ok(registrierung.render());	
    	}
    	
		
	}
    
    public static Result changeUserData(){
    	return ok(userDatenAendern.render());
    }
    
	public static Result verkaufen(){
		
		if(isLogged==true){
		return ok(verkaufen.render());
		}else{
			return ok(registrierung.render());
		}
   }
	
	public static Result einkaufen(){
		return ok(einkaufen.render(Model.getBookList()));
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
		newBook.setUser(Model.getActivUser());
		
		Model.getActivUser().getUserBook().add(newBook);
		Model.getBookList().add(newBook);
		
		return ok(profile.render(Model.getActivUser().getUserBook(),Model.getActivUser()));
	}

	
	public static Result deleteBook(String deleteBookISBN){
		Book deleteBook=null;
		for(Book book: Model.getBookList()){
			if(book.getISBN().equals(deleteBookISBN)){
				deleteBook=book;
			}
		}
		Model.getBookList().remove(deleteBook);
		Model.getActivUser().getUserBook().remove(deleteBook);
		return ok(profile.render(Model.getActivUser().getUserBook(),Model.getActivUser()));
	}
	
	public static Result addUser(String FirstName, 							  
								  String Email){
		User newUser = new User();
		
		newUser.setFirstName(FirstName);
		newUser.setEmail(Email);
		newUser.setPassword("0");
		Model.getUserList().add(newUser);
		Model.setActivUser(newUser);
		isLogged = true;
		return ok(profile.render(Model.getActivUser().getUserBook(),Model.getActivUser()));
		
	}
	
	public static Result logIn(String benutzername, String passwort){
		
		for(User user : Model.getUserList()){
			if(benutzername.equals(user.getFirstName()) && passwort.equals(user.getPassword()) ){
				isLogged = true;
				Model.setActivUser(user);
				return ok(profile.render(Model.getActivUser().getUserBook(),Model.getActivUser()));
			}
		}
		return ok(registrierung.render());
	}
	
	public static Result logOut(){
		
		Model.setActivUser(null);
		isLogged = false;
		
		return ok(index.render());
	}
	
}
