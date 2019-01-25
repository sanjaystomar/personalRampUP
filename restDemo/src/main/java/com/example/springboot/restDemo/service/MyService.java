package com.example.springboot.restDemo.service;

import org.springframework.stereotype.Service;

@Service
public class MyService {

    public String getMessage(){
        return System.currentTimeMillis() + "\n Hi How are you!!";
    }
}
