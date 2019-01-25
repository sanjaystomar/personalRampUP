package com.example.springboot.restDemo.controller;

import com.example.springboot.restDemo.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class FirstRestController {
    @Autowired
    private MyService myService;

    @GetMapping("/myRest")
    public String myString(){
        return myService.getMessage();
    }

}
