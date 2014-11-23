package models;

public class Book {
	
	private String BookName;
	private String Auther;
	private String Prof;
	private String Date;
	private String Layer;
	private String Condition;
	private String ISBN;
	private String Price; 	

	public String getBookName() {
		return BookName;
	}

	public void setBookName(String bookName) {
		BookName = bookName;
	}

	public String getAuther() {
		return Auther;
	}

	public void setAuther(String auther) {
		Auther = auther;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getProf() {
		return Prof;
	}

	public void setProf(String prof) {
		Prof = prof;
	}

	public String getCondition() {
		return Condition;
	}

	public void setCondition(String condition) {
		Condition = condition;
	}

	public String getLayer() {
		return Layer;
	}

	public void setLayer(String layer) {
		Layer = layer;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getPrice() {
		return Price;
	}

	public void setPrice(String price) {
		Price = price;
	}
	
	

}
