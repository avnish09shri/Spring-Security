package com.springsecurity.service.interfaces;

import com.springsecurity.model.Contact;
import com.springsecurity.model.response.ContactResponse;

public interface ContactService {

    ContactResponse saveContactMessage(Contact contact);
}
