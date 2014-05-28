package com.mc.spring.sample.web.controllers;

import com.mc.spring.sample.web.services.security.CustomUserDetailsService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
public class AuthEndpoint {

    /**
     * Endpoint that can be used to check if a user is "logged in"/
     */
    @Secured(CustomUserDetailsService.SpecificUserDetails.ROLE_USER)
    @RequestMapping(value = "/test", method = RequestMethod.GET, headers = "Accept=application/json")
    public String endpointNameTest() {
        return "Authenticated";   //TODO: get current user or some custom logic
    }

}
