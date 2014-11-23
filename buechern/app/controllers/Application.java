package controllers;

import java.util.ArrayList;



import models.Book;
import play.*;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {
	
	
	static ArrayList <Book> BookList = new ArrayList<Book>();
	
    public static Result index() {
        return ok(index.render());
    }
    public static Result  profile() {
    	
    	if(BookList.isEmpty()){
    		
    		return ok(profile.render("","","",false));
    		
    	}else{
    		
    		return ok(profile.render(BookList.get(0).getBookName(),BookList.get(0).getAuther(),BookList.get(0).getISBN(),true));
    	}
    	
		
	}
    
    public static Result changeUserData(){
    	return ok(userDatenAendern.render());
    }
    
	public static Result verkaufen(){
		return ok(verkaufen.render());
   }
	
	public static Result einkaufen(){
		return ok(einkaufen.render());
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
		
		return ok(index.render());
	}

	
	public static Result deleteBook(){
		
		BookList.remove(0);
		
		return ok(index.render());
	}

	
}
