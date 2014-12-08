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

				return ok(profile.render(Model.getBookList(),Model.getActivUser()));

			}else{

				return ok(profile.render(Model.getBookList(),Model.getActivUser()));
			}
		}else{

			return ok(registrierung.render(false));	
		}

		
	}

	public static Result changeUserData(){
		return ok(userDatenAendern.render());
	}

	public static Result verkaufen(){
		
		if(isLogged==true){
			return ok(verkaufen.render());
		}else{
			return ok(registrierung.render(false));
		}
	}
	
	public static Result einkaufen(){
		ArrayList<Book> returnBook = new ArrayList<Book>();
		for(Book book : Model.getBookList()){
			if(book.getStatus()==0){
				returnBook.add(book);
			}
		}
		
		return ok(einkaufen.render(returnBook));
	}
	
	public static Result registrierung(){
		return ok(registrierung.render(false));
	}
	
	public static Result addBook(String Booktitel, 
		String Autor, 
		String Erscheinungsjahr, 
		String ISBN , 
		String Auflage, 
		String Zustand, 
		String Preis, 
		String BoolFestpreis){
		AppBookOptions.addBook(Booktitel, Autor, Erscheinungsjahr, ISBN, Auflage, Zustand, Preis, BoolFestpreis);
		
		return ok(profile.render(Model.getBookList(),Model.getActivUser()));
	}

	
	public static Result deleteBook(int id){
		AppBookOptions.deleteBook(id);
		return ok(profile.render(Model.getBookList(),Model.getActivUser()));
	}
	
	public static Result addUser(String FirstName,
		String LastName,
		String Email, String EmailRep, 
		String Passwort, String PasswortRep){

		User newUser = new User();
		
				newUser.setFirstName(FirstName);
				newUser.setEmail(Email);
				newUser.setPassword(Passwort);

				Model.addUser(newUser);
				Model.getActivUser().getUserBook().clear();
				Model.getActivUser().getMarketBasket().clear();

				Model.setActivUser(newUser);
				isLogged = true;
				
				return ok(profile.render(Model.getBookList(),Model.getActivUser()));
	}
	
	public static Result logIn(String benutzername, String passwort){
		
		for(User user : Model.getUserList()){
			
			if(benutzername.equals(user.getFirstName()) && passwort.equals(user.getPassword()) ){
				isLogged = true;
				Model.setActivUser(user);
				Model.getActivUser().getUserBook().clear();
				
				for(Book book : Model.getBookList()){
					System.out.println(book.getUser());
					if(user.equals(book.getUser())){
						Model.getActivUser().getUserBook().add(book);
					}
					
				}
			
				return ok(profile.render(Model.getBookList(),Model.getActivUser()));
			}
		}
		return ok(registrierung.render(false));
	}
	
	public static Result logOut(){
		
		Model.setActivUser(null);
		isLogged = false;
		
		return ok(index.render());
	}
	public static Result buyBook(int id){
			
		if(isLogged==false){
			return redirect("/profile");
		}else{
			
		
			for(Book book : Model.getBookList()){
				if(book.getId()==id){
		
					book.setStatus(1);
					book.setBuyer(Model.getActivUser());

				}
			}
		
			return redirect("/profile");
		}
	}
	
	public static Result changePass(String oldPass, String newPass ){
			
			if(Model.getActivUser().getPassword().equals(oldPass)){
				Model.getActivUser().setPassword(newPass);
				return ok(profile.render(Model.getBookList(),Model.getActivUser()));
			}else{
				return ok(userDatenAendern.render());
			}
	}
	
	public static Result changeEmail(String oldEmail, String newEmail ){
		
		if(Model.getActivUser().getEmail().equals(oldEmail)){
			Model.getActivUser().setEmail(newEmail);
			return ok(profile.render(Model.getBookList(),Model.getActivUser()));
		}else{
			return ok(userDatenAendern.render());
		}
	}
	
	public static Result searchBook(String suche){
		ArrayList<Book> foundBooks = new ArrayList<Book>();
		for(Book book :Model.getBookList()){
			if(book.getStatus()==0){
				
				suche = suche.replaceAll(" ", "").replaceAll(":", "").toLowerCase();
				
				if(book.getBookName().toLowerCase().replaceAll(" ", "").contains(suche)
						||book.getAuther().toLowerCase().replaceAll(" ", "").contains(suche)
						||book.getISBN().toLowerCase().replaceAll(" ", "").contains(suche)
						||suche.contains(book.getISBN().toLowerCase().replaceAll(" ", ""))
						||suche.contains(book.getAuther().toLowerCase().replaceAll(" ", ""))
						||suche.contains(book.getBookName().toLowerCase().replaceAll(" ", ""))){
					
					foundBooks.add(book);
				}
			}
		}
		
		return ok(einkaufen.render(foundBooks));
	}
}

