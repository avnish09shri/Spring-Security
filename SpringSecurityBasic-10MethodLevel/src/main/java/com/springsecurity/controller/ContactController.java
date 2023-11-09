package com.springsecurity.controller;

import com.springsecurity.model.Contact;
import com.springsecurity.service.classes.ContactServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContactController {

    private final ContactServiceImpl contactServiceImpl;

    public ContactController(ContactServiceImpl contactServiceImpl) {
        this.contactServiceImpl = contactServiceImpl;
    }

    @PostMapping("/contact")
    //@PreFilter("filterObject.contactName!='Test'")
    @PostFilter("filterObject.contactName!='Test'")
    public ResponseEntity<List<Contact>> saveContactInquiryDetails(@RequestBody List<Contact> contacts) {
        return new ResponseEntity<>(contactServiceImpl.saveContactMessage(contacts), HttpStatus.CREATED);
    }

}
