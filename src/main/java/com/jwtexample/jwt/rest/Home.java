package com.jwtexample.jwt.rest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Home{

    @RequestMapping(path = "/home", method = RequestMethod.GET)
    public String index() {
        return "Home";
    }

    @RequestMapping(path = "/admin", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN')")
    public String getProtectedGreeting() {
        return " admin ";
    }

}
