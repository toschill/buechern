package models;

import java.util.Collection;
import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;


public class StaticObservable{

	public static Collection<Observer> observers = new HashSet<Observer>();
	
	public static void addObserver(Observer o){
		if(!observers.contains(o))
		System.out.println("Observer added");
		observers.add(o);
	}
	
	public static void deleteObserver(Observer o){
		observers.remove(o);
	}

	public static void notifyObservers(Object obj){
		System.out.println("NOTIFY OBSERVERS");
		for(Observer o : observers){
			System.out.println("notify");
			System.out.println("Observer notified");
			o.update(new Observable(), obj);
		}
	}
	
}
