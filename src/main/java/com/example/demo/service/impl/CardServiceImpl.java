package com.example.demo.service.impl;

import com.example.demo.entities.Card;
import com.example.demo.exceptions.CustomException;
import com.example.demo.repositories.CardRepo;
import com.example.demo.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    CardRepo cardRepo;

    @Override
    public List<Card> getAllCards() {
        return cardRepo.findAll();
    }

    @Override
    public ResponseEntity<?> addCard(Card card) throws CustomException {
        ResponseEntity responseEntity;
        if(card.getName()=="" || card.getName()==null){
            throw new CustomException("Invalid name");
        }
        else{
            cardRepo.save(card);
            return new ResponseEntity(cardRepo.save(card), HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<?> deleteCard(Card card) throws CustomException {
        ResponseEntity responseEntity;
        try {
            cardRepo.deleteById(card.getCardNo());
            responseEntity = new ResponseEntity("Card was deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            throw new CustomException("Card ID invalid");
        }
        return responseEntity;
    }
}
