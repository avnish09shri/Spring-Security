package com.springsecurity.service.interfaces;

import com.springsecurity.model.Cards;

import java.util.List;

public interface CardService {

    List<Cards> findCards(int id);
}
