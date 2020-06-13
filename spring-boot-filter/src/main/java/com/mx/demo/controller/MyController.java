package com.mx.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class MyController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String first(){
        return "hello";
    }
}
