package controllers;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import play.mvc.Controller;
import play.mvc.Result;
import services.ServicesConfig;
import services.persistence.model.User;
import services.UserService;

public class Application extends Controller {

    public static Result index() {
        //return ok(index.render("Your new application is ready."));
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ServicesConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.saveUser(new User("user", "u", "s", "u@s.er"));

        return ok("Hello world 234");

    }

}
