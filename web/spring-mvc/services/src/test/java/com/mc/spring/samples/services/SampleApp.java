package com.mc.spring.samples.services;

import com.mc.spring.samples.services.persistence.model.User;
import com.mc.spring.samples.services.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SampleApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ServicesConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.saveUser(new User("user", "u", "s", "u@s.er"));

        System.out.println(userService.getUsers());
    }
}
