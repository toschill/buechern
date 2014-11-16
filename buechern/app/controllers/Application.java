package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render());
    }
    public static Result  profile() {
		return ok(profile.render());
	}
    
    public static Result changeUserData(){
    	return ok(userDatenAendern.render());
    }
    
	public static Result verkaufen(){
		return ok(verkaufen.render());
   }
}
