package com.example.demo.service;

import javax.xml.ws.WebFault;

@WebFault(name = "MissingId" , targetNamespace="http://spring.io/guides/gs-producing-web-service")
public class MissingField extends Exception{
    public MissingField() {
        super("One of the fields is missing, please add all the required fields");
    }
}
