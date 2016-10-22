package com.mc.spring.samples.console.app;

import com.mc.spring.samples.console.persistence.model.User;
import com.mc.spring.samples.console.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SampleApp {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        System.out.println("Context initialized");

        UserService userService = context.getBean(UserService.class);

        userService.saveUser(new User("user", "u", "s", "u@s.er"));

        System.out.println(userService.getUsers());
    }
}