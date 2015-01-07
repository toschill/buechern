package models;

import java.util.Collection;
import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;


public class StaticObservable{

	public static Collection<Observer> observers = new HashSet<Observer>();
	
	public static void addObserver(Observer o){
		observers.add(o);
	}
	
	public static void deleteObserver(Observer o){
		observers.remove(o);
	}

	public static void notifyObservers(Object obj){
		for(Observer o : observers){
			o.update(new Observable(), obj);
		}
	}
	
}
