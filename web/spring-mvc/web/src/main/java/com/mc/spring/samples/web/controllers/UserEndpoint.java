package com.mc.spring.samples.web.controllers;

import com.mc.spring.samples.services.persistence.model.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserEndpoint {


    @RequestMapping(value = "/endpoint", method = RequestMethod.GET, headers = "Accept=text/plain")
    public String endpointName() {
        return "USERS";
    }

    @RequestMapping(value = "/forbidden", method = RequestMethod.GET, headers = "Accept=text/plain")
    public ResponseEntity<String> responseCode() {
        return new ResponseEntity<>("Custom status code: 403 Forbidden", HttpStatus.FORBIDDEN);
    }


    @RequestMapping(value = "/oneUserOK", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> oneUser_responseEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(new User("mmay", "Maybe", "May", "mmay@gmail.com"), headers, HttpStatus.OK);
    }


    @RequestMapping(value = "/oneUserJson", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public User oneUser_json() {
        return new User("mmay", "Maybe", "May", "mmay@gmail.com");
    }

    @RequestMapping(value = "/allUsers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAllUsers() {
        List<User> response = new ArrayList<>();
        //TODO: invoke service and get the actual list.
        return response;
    }


}
