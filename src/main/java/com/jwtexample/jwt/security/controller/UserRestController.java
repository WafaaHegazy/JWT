package com.jwtexample.jwt.security.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jwtexample.jwt.config.user.User;

@RestController
public class UserRestController {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public User getAuthenticatedUser(final HttpServletRequest request) {
        final String token = request.getHeader(tokenHeader);
        final String username = jwtTokenUtil.getUsernameFromToken(token);
        final User user = (User) userDetailsService.loadUserByUsername(username);
        return user;
    }

}
