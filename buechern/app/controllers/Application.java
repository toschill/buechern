package controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;
import java.util.Observer;

import models.Book;
import models.Model;
import models.User;

import org.mindrot.jbcrypt.BCrypt;

import play.data.DynamicForm;
import play.data.Form;

import play.libs.Akka;
import play.libs.F.Callback0;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.WebSocket;
import scala.concurrent.duration.Duration;
import views.html.einkaufen;
import views.html.index;
import views.html.profile;
import views.html.registrierung;
import views.html.userDatenAendern;
import views.html.verkaufen;
import views.html.searchBookShow;
import akka.actor.ActorRef;
import akka.actor.Cancellable;
import akka.actor.Props;

import views.html.play20.book;



public class Application extends Controller implements Observer {
	
	public static Application app = new Application();

	/**
	 * Get the active User from session
	 * @return User active User			
	 */
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
	
	/**
	 *Add User to Session
	 * 
	 * @param user 
	 * 			active User for adding to session
	 */
	
	public static void addUserToSession(User user){
		Integer userid = new Integer(user.getId());
		System.out.println("addUserToSession: Add User "+userid+" to session");
		session("USER", userid.toString());
	}
	
	/**
	 * Go to Index Page
	 * @return Index Page
	 */
	public static Result index() {
		Model.addObserver(Application.app);
		statusWs();
		return ok(index.render());
	}
	
	/**
	 * Go to Profile Page
	 * 
	 * @return Resgistrieren Page if User is not logged in
	 * @return Profile Page if User is logged in
	 */
	public static Result profile() {
		String userCode ="";
		userCode = session().get("USER");
		
		System.out.println("Profile: "+userCode+" Result from session");
		User user = getUserFromSession();
		if (user == null) {
			return ok(registrierung.render(false));
		} else {

			System.out.println("Profile: " + user.getFirstName()+ " User Profile");
			return ok(profile.render(Model.getBookList(), user));
		}
	}

	/**
	 * Go to ChangeUserData Page
	 * @return UserDatenAendern Page
	 */
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
		return ok(einkaufen.render());
	}
	
	public static Result registrierung(){
		return ok(registrierung.render(false));
	}
	
	/**
	 * add new Book
	 * - get book details (dynamicForm.get())
	 * 
	 * @return Go to Profile Page
	 */
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
	
	/**
	 * add new User to DB
	 * create new Hash Password 
	 * add new User to session
	 * @param firstName 
	 * 				get firstName (dynamicForm.get())
	 * @param LastName 
	 * 				get LastName (dynamicForm.get())
	 * @param email 
	 * 				get email (dynamicForm.get())
	 * @param emailRep 
	 * 				get emailRep (dynamicForm.get())
	 * @param passwort 
	 * 				get passwort (dynamicForm.get())
	 * @param PasswortRep 
	 * 				get PasswortRep (dynamicForm.get())
	 * @return Profile Page
	 */
	public static Result addUser(String firstName,
		String LastName,
		String email, String emailRep, 
		String passwort, String PasswortRep){

		User newUser = new User();
				newUser.setFirstName(firstName);
				newUser.setEmail(email);
				
				newUser.setPassword(BCrypt.hashpw(passwort, BCrypt.gensalt()));
				System.out.println("addUser: create hach pass. "+ BCrypt.hashpw(passwort, BCrypt.gensalt()) +" for NewUser");
				Model.addUser(newUser);
				//Model.getActivUser().getUserBook().clear();
				
				for(User user: Model.getUserList()){
					if(firstName.equals(user.getFirstName()) && BCrypt.checkpw(passwort, user.getPassword())){
					
						addUserToSession(user);
						System.out.println("addUser: "+session().get("USER")+ " User from Session");
			
					
						return ok(profile.render(Model.getBookList(), user));
						
					}
				}
			
				return ok(profile.render(Model.getBookList(), newUser));
	}
	
	/**
	 * Log in User
	 * check password an User Name (Model.getUserList() and check each User)
	 * 
	 * @return if Login Data ok, Profile Page
	 * @return if Login Error, Registrieren Page
	 */
	
	public static Result logIn(){
		
		DynamicForm dynamicForm = Form.form().bindFromRequest();
		
		String benutzername = dynamicForm.get("benutzername");
		String passwort= dynamicForm.get("passwort");
		
		User returnUser = new User();
		for(User user : Model.getUserList()){
			
			System.out.println("logIn : Password from User "+ user.getFirstName()+" is: "+user.getPassword());
			System.out.println("logIn : Password ok: "+(BCrypt.checkpw(passwort, user.getPassword())));
			
			if(benutzername.equals(user.getFirstName()) && (BCrypt.checkpw(passwort, user.getPassword()))){
								
				addUserToSession(user);
				System.out.println("LogIn: "+session().get("USER")+ " User");
				returnUser = user;
			
				return ok(profile.render(Model.getBookList(), returnUser));
				
			}
		}
		System.out.println("logIn: wrong Password or Username!");
		return ok(registrierung.render(false));
	}
	
	/**
	 * Log out User
	 * - get user from Session
	 * - clear Session
	 * @return
	 */
	public static Result logOut(){
		System.out.println("LogOut: delete User "+getUserFromSession().getId()+" from Session");
		session().clear();
		return ok(index.render());
	}
	
	/**
	 * Buy Book
	 * 
	 * @param id
	 * @return
	 */
	public static Result buyBook(int id){
		System.out.println(id + " wird gekauft");
		if(getUserFromSession()==null){
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
			
			if(BCrypt.checkpw(oldPass, getUserFromSession().getPassword())){
				
				Model.changePassword((BCrypt.hashpw(newPass, BCrypt.gensalt())), getUserFromSession());
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
		System.out.println("searchBook: enter with String: "+suche);
		for(Book book :Model.getBookList()){
			if(suche.equals("")){
				if(book.getStatus()==0){
					foundBooks.add(book);
				}
			}else{
			
				if(book.getStatus()==0){
					
					suche = suche.replaceAll(" ", "").replaceAll(":", "").toLowerCase();
					
					if(book.getBookName().toLowerCase().replaceAll(" ", "").contains(suche)
							||book.getAuther().toLowerCase().replaceAll(" ", "").contains(suche)
							||book.getISBN().toLowerCase().replaceAll(" ", "").contains(suche)
							||book.getPrice().toLowerCase().replaceAll(" ", "").contains(suche)
							||suche.contains(book.getISBN().toLowerCase().replaceAll(" ", ""))
							||suche.contains(book.getAuther().toLowerCase().replaceAll(" ", ""))
							||suche.contains(book.getPrice().toLowerCase().replaceAll(" ", ""))
							||suche.contains(book.getBookName().toLowerCase().replaceAll(" ", ""))){
						foundBooks.add(book);
					}
				}
			}
		}
		
		return ok(searchBookShow.render(foundBooks));
	}

	


	public static WebSocket<String> statusWs() {
	    return new WebSocket<String>() {
	        public void onReady(WebSocket.In<String> in, WebSocket.Out<String> out) {
	            final ActorRef pingActor = Akka.system().actorOf(Props.create(StatusWS.class, in, out));
	            final Cancellable cancellable = Akka.system().scheduler().schedule(Duration.create(1, "seconds"),
	                                               Duration.create(1, "seconds"),
	                                               pingActor,
	                                               "Status",
	                                               Akka.system().dispatcher(),
	                                               null
	                                               );

	            in.onClose(new Callback0() {
	                @Override
	                public void invoke() throws Throwable {
	                    cancellable.cancel();
	                }
	            });
	        }

	    };
	}

	
	
	@Override
	public void update(Observable o, Object arg) {
		if(arg instanceof User){
			User user = (User) arg;
			Model.schreibeStatus(" | Wir haben einen neuen Benutzer: " +user.getFirstName());
			System.out.println(" | Wir haben einen neuen Benutzer: " +user.getFirstName());
		}
		if(arg instanceof Book){
			Book book = (Book) arg;
			Model.schreibeStatus(" | Es wurde ein neues Buch erstellt: " +book.getBookName());
			System.out.println(" | Es wurde ein neues Buch erstellt: " +book.getBookName());
		}
	}
}

