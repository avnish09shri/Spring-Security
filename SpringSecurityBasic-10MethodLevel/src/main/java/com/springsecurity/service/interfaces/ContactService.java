package com.springsecurity.service.interfaces;

import com.springsecurity.model.Contact;

import java.util.List;

public interface ContactService {

    List<Contact> saveContactMessage(List<Contact> contact);
}
