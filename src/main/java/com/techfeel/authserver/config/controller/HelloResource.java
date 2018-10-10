package com.techfeel.authserver.config.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * 
 * @author bhavesh bhatt
 *
 */
@RestController
@RequestMapping("/rest/hello")
public class HelloResource {


    @GetMapping("/principal")
    public Principal user(Principal principal) {
        return principal;
    }
    @GetMapping
    public String hello() {
        return "Hello World";
    }
}