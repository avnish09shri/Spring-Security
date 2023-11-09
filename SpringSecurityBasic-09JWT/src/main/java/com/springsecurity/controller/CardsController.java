package com.springsecurity.controller;

import com.springsecurity.model.Cards;
import com.springsecurity.service.classes.CardServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardsController {

    private final CardServiceImpl cardServiceImpl;

    public CardsController(CardServiceImpl cardServiceImpl) {
        this.cardServiceImpl = cardServiceImpl;
    }

    @GetMapping("/myCards")
    public ResponseEntity<List<Cards>> getCardDetails(@RequestParam int id) {

        return new ResponseEntity<>(cardServiceImpl.findCards(id), HttpStatus.OK);
    }

}
