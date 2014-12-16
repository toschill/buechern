package controllers;

import java.util.ArrayList;

import models.Book;
import models.Model;
import models.User;
import play.*;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.*;
import views.html.*;


public class Application extends Controller {
	
	
	
	
	static Boolean isLogged = false;
	
	
	
	public static Result index() {
		
		return ok(index.render());
	}

	public static Result  profile() {
		User returnUser = new User();
	
		String userCode = session().get("USER");
		
		for(User user : Model.getUserList()){
			if(user.toString().equals(userCode)){
				
				returnUser=user;
			}
		}
		
		if(returnUser.equals(null)){
			
			return ok(registrierung.render(false));
		}else{
			System.out.println("Profile: "+returnUser.getFirstName()+" Profile");
			return ok(profile.render(Model.getBookList(),returnUser));
		}
		
		//if(isLogged == true){

			//if(Model.getBookList().isEmpty()){

				//return ok(profile.render(Model.getBookList(),Model.getActivUser()));

			//}else{

				//return ok(profile.render(Model.getBookList(),Model.getActivUser()));
			//}
		//}else{

			
		//}

		
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
		//KONSTANTE hinzufügen
		return ok(einkaufen.render(Model.getBooks(0)));
	}
	
	public static Result registrierung(){
		return ok(registrierung.render(false));
	}
	
	public static Result addBook(){
		
		DynamicForm dynamicForm = Form.form().bindFromRequest();
		
		String Booktitel = dynamicForm.get("Booktitel");
		String Autor = dynamicForm.get("Autor");
		String Erscheinungsjahr = dynamicForm.get("Erscheinungsjahr");
		String ISBN =dynamicForm.get("ISBN");
		String Auflage = dynamicForm.get("Auflage");
		String Zustand = dynamicForm.get("Zustand");
		String Preis = dynamicForm.get("Preis");
	
		AppBookOptions.addBook(Booktitel, Autor, Erscheinungsjahr, ISBN, Auflage, Zustand, Preis);
		
		return ok(profile.render(Model.getBookList(),Model.getActivUser()));
	}

	
	public static Result deleteBook(int id){
		AppBookOptions.deleteBook(id);
		System.out.println("Delete Book with ID: "+ id);
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
				//Model.getActivUser().getUserBook().clear();

				Model.setActivUser(newUser);
				isLogged = true;
				
				System.out.println("Add User: "+Model.getActivUser().getFirstName());
			
				
				return ok(profile.render(Model.getBookList(), Model.getActivUser()));
	}
	
	public static Result logIn(){
		
		DynamicForm dynamicForm = Form.form().bindFromRequest();
		
		String benutzername = dynamicForm.get("benutzername");
		String passwort= dynamicForm.get("passwort");
		
		User returnUser = new User();
		
		for(User user : Model.getUserList()){
			
			if(benutzername.equals(user.getFirstName()) && passwort.equals(user.getPassword()) ){
				
				isLogged = true;
				
				Integer userid = new Integer(user.getId());
				
				session("USER", userid.toString());
				
				System.out.println("LogIn: "+session().get("USER")+ " User from Session");
				returnUser = user;
				
				//Model.setActivUser(user);
				//.getActivUser().getUserBook().clear();
				
				//for(Book book : Model.getBookList()){
					
					//if(user.equals(book.getUser())){
						
						//Model.getActivUser().getUserBook().add(book);
					//}
					
				//}
			
				return ok(profile.render(Model.getBookList(), returnUser));
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
		System.out.println(id + " wird gekauft");
		if(isLogged==false){
			return redirect("/profile");
		}else{
			for(Book book : Model.getBookList()){
				if(book.getId()==id){
					System.out.println("Buch " + book.getBookName()+ " gekauft");
					Model.buyBook(Model.getActivUser(), book);
					//book.setStatus(1);
					//book.setBuyer(Model.getActivUser());

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

