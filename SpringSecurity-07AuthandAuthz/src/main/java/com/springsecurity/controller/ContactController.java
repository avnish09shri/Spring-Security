package com.springsecurity.controller;

import java.sql.Date;
import java.util.Random;

import com.springsecurity.service.classes.ContactServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springsecurity.model.Contact;
import com.springsecurity.repository.ContactRepository;

@RestController
public class ContactController {

    private final ContactServiceImpl contactServiceImpl;

    public ContactController(ContactServiceImpl contactServiceImpl) {
        this.contactServiceImpl = contactServiceImpl;
    }

    @PostMapping("/contact")
    public ResponseEntity<Contact> saveContactInquiryDetails(@RequestBody Contact contact) {
        return new ResponseEntity<>(contactServiceImpl.saveContactMessage(contact), HttpStatus.CREATED);
    }

}
