package com.springsecurity.service;

import com.springsecurity.model.Contact;
import com.springsecurity.model.response.ContactResponse;
import com.springsecurity.repository.ContactRepository;
import com.springsecurity.service.interfaces.ContactService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Random;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }


    @Override
    public ContactResponse saveContactMessage(Contact contact) {
        contact.setContactId(getServiceReqNumber());
        contact.setCreateDt(new Date(System.currentTimeMillis()));
        return mapToResponse(contactRepository.save(contact));
    }

    private ContactResponse mapToResponse(Contact contact) {
        ContactResponse contactResponse=new ContactResponse();
        BeanUtils.copyProperties(contact, contactResponse);
        return  contactResponse;
    }

    public String getServiceReqNumber() {
        Random random = new Random();
        int ranNum = random.nextInt(999999999 - 9999) + 9999;
        return "SR"+ranNum;
    }
}
