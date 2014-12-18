package controllers;

import java.util.ArrayList;

import org.mindrot.jbcrypt.*;

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
	
	public static User getUserFromSession(){
		String userCode ="";
		userCode = session("USER");
		try {
			if(userCode.equals("")){
				return null;
			}else{
				Integer userid = new Integer(userCode);
				
				for(User user : Model.getUserList()){
					if(user.getId()==userid){
						System.out.println("getUserFromSession: get "+user.getFirstName()+" User from Session");
						return user;
					}
				}
			}
		} catch (NullPointerException e) {
			System.out.println("getUserFromSession: " +e+" because of no User loged in");
		}
		
		return null;
	}
	
	public static void addUserToSession(User user){
		Integer userid = new Integer(user.getId());
		System.out.println("addUserToSession: Add User "+userid+" to session");
		session("USER", userid.toString());
	}
	
	
	public static Result index() {
		
		return ok(index.render());
	}

	public static Result profile() {
		String userCode ="";
		userCode = session().get("USER");
		
		System.out.println("Profile: "+userCode+" Result from session");
		User user = getUserFromSession();
		if (user == null) {
			return ok(registrierung.render(false));
		} else {

			System.out.println("Profile: " + user.getFirstName()+ " User to Session");
			return ok(profile.render(Model.getBookList(), user));
		}
	}

	
	public static Result changeUserData(){
		return ok(userDatenAendern.render());
	}

	public static Result verkaufen(){
		
		if(!(getUserFromSession()==null)){
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
		
		User returnUser = getUserFromSession();
		
		return ok(profile.render(Model.getBookList(),returnUser));
	}

	
	public static Result deleteBook(int id){
		AppBookOptions.deleteBook(id);
		User returnUser = getUserFromSession();
		System.out.println("Delete Book with ID: "+ id);
		return ok(profile.render(Model.getBookList(),returnUser));
	}
	
	public static Result addUser(String firstName,
		String LastName,
		String email, String emailRep, 
		String passwort, String PasswortRep){

		User newUser = new User();
				passwort = BCrypt.hashpw(passwort, BCrypt.gensalt());
				newUser.setFirstName(firstName);
				newUser.setEmail(email);
				newUser.setPassword(passwort.hashCode());
				
				Model.addUser(newUser);
				//Model.getActivUser().getUserBook().clear();
				
				for(User user: Model.getUserList()){
					if(firstName.equals(user.getFirstName()) && passwort.hashCode()==user.getPassword() ){
					
						addUserToSession(user);
						System.out.println("addUser: "+session().get("USER")+ " User from Session");
			
					
						return ok(profile.render(Model.getBookList(), user));
						
					}
				}
			
				return ok(profile.render(Model.getBookList(), newUser));
	}
	
	public static Result logIn(){
		
		DynamicForm dynamicForm = Form.form().bindFromRequest();
		
		String benutzername = dynamicForm.get("benutzername");
		String passwort= dynamicForm.get("passwort");
		
		User returnUser = new User();
		//toDo change password from int to string
	//	passwort = BCrypt.hashpw(passwort, BCrypt.gensalt());
	//	System.out.println("logIn : new Hash code:" +passwort);
		
		for(User user : Model.getUserList()){
			
			
			if(benutzername.equals(user.getFirstName()) && passwort.hashCode()==user.getPassword() ){
				
				isLogged = true;
				addUserToSession(user);
				System.out.println("LogIn: "+session().get("USER")+ " User");
				returnUser = user;
			
				return ok(profile.render(Model.getBookList(), returnUser));
				
			}
		}
		System.out.println("logIn: wrong Password or Username!");
		return ok(registrierung.render(false));
	}
	
	public static Result logOut(){
		System.out.println("LogOut: delete User "+getUserFromSession().getId()+" from Session");
		session().clear();
		return ok(index.render());
	}
	public static Result buyBook(int id){
		System.out.println(id + " wird gekauft");
		if(isLogged==false){
			return redirect("/profile");
		}else{
			for(Book book : Model.getBookList()){
				if(book.getId()==id){
					System.out.println("buyBook: "+"Buch " + book.getBookName()+ " gekauft");
					Model.buyBook(getUserFromSession(), book);
					//book.setStatus(1);
					//book.setBuyer(Model.getActivUser());

				}
			}
		
			return redirect("/profile");
		}
	}
	
	public static Result changePass(String oldPass, String newPass ){
			
			if((getUserFromSession().getPassword()) ==(oldPass.hashCode())){
				Model.changePassword(newPass.hashCode(), getUserFromSession());
				System.out.println("changePass: Password changed form "+oldPass+" to "+ newPass);
				return ok(profile.render(Model.getBookList(),getUserFromSession()));
				
			}else{
				return ok(userDatenAendern.render());
			}
	}
	
	public static Result changeEmail(String oldEmail, String newEmail ){
		
		if(getUserFromSession().getEmail().equals(oldEmail)){
			getUserFromSession().setEmail(newEmail);
			return ok(profile.render(Model.getBookList(),getUserFromSession()));
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

