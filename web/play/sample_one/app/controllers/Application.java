package controllers;

import play.*;
import play.mvc.*;

import views.html.*;
import views.html.index;

public class Application extends Controller {

    public static Result index() {
        //return ok(index.render("Your new application is ready."));
	    return ok("Hello world 234");

    }

}
