package controllers;

import models.Book;
import models.Model;
import models.User;

public class AppBookOptions {
	/**
	 * Add Book to DB
	 * 
	 * @param Booktitel 
	 * @param Autor
	 * @param Erscheinungsjahr
	 * @param ISBN
	 * @param Auflage
	 * @param Zustand
	 * @param Preis
	 */
	public static void addBook(	String Booktitel, 
								String Autor, 
								String Erscheinungsjahr, 
								String ISBN , 
								String Auflage, 
								String Zustand, 
								String Preis){
		Book newBook = new Book();
		
		
		newBook.setBookName(Booktitel);
		newBook.setAuther(Autor);
		newBook.setDate(Erscheinungsjahr);
		newBook.setISBN(ISBN);
		newBook.setLayer(Auflage);
		newBook.setCondition(Zustand);
		newBook.setPrice(Preis);
		newBook.setUser(Application.getUserFromSession());
		newBook.setId(Model.getBookNumber());
		Model.setBookNumber(+1);
	
		
		//Model.getActivUser().getUserBook().add(newBook);
		Model.addBook(newBook);
							
	}
	
	public static void deleteBook(int id){
		Book deleteBook=null;
		for(Book book: Model.getBookList()){
			if(book.getId() == id){
				deleteBook=book;
			}
		}
		Model.deleteBook(deleteBook);
		Model.getActivUser().getUserBook().remove(deleteBook);
	}

}
