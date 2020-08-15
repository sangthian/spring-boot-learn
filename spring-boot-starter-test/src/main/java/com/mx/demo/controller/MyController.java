package com.mx.demo.controller;

import com.mx.demo.service.MxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @Autowired
    private MxService mxService;

    @RequestMapping(value = "/health", method = RequestMethod.GET)
    public String health() {
        return "ok";
    }

    @RequestMapping(value = "/print", method = RequestMethod.GET)
    public void print() {
        mxService.print();
    }
}
