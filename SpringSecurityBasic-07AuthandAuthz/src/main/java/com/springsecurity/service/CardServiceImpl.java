package com.springsecurity.service;

import com.springsecurity.model.Cards;
import com.springsecurity.repository.CardsRepository;
import com.springsecurity.service.interfaces.CardService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    private final CardsRepository cardsRepository;

    public CardServiceImpl(CardsRepository cardsRepository) {
        this.cardsRepository = cardsRepository;
    }


    @Override
    public List<Cards> findCards(int id) {
        List<Cards> cards = cardsRepository.findByCustomerId(id);
        if(cards.size()>0 || cards!=null)
            return cards;
        else
            return new ArrayList<>();
    }
}
