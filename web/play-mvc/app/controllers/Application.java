package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import play.mvc.Controller;
import play.mvc.Result;
import services.UserService;
import services.persistence.model.User;

@org.springframework.stereotype.Controller
public class Application extends Controller {

    @Autowired
    private UserService userService;

    public Result index() {

        //return ok(index.render("Your new application is ready."));

        userService.saveUser(new User("user", "u", "s", "u@s.er"));

        return ok("Hello world 234");

    }

}
