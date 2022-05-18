package com.myadream.app.authorize.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("authorize")
public class AuthorizeController {
    @GetMapping
    public String authorize(){
       return "Hello World";
    }
}
