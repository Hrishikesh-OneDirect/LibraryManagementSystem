package com.example.demo.controllers;

import com.example.demo.entities.Card;
import com.example.demo.exceptions.CustomException;
import com.example.demo.repositories.CardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CardController {
    @Autowired
    CardRepo cardRepo;

    @GetMapping("/getAllCards")
    public List<Card> getALlCards(){
        return cardRepo.findAll();
    }

    @PostMapping("/addCard")
    public ResponseEntity<?> addCard(@RequestBody Card card) throws CustomException{
        ResponseEntity responseEntity;
        if(card.getName()=="" || card.getName()==null){
            throw new CustomException("Invalid name");
        }
        else{
            cardRepo.save(card);
            return new ResponseEntity(cardRepo.save(card), HttpStatus.OK);
        }
    }

    @DeleteMapping("/deleteCard")
    public ResponseEntity<?> deleteCard(@RequestBody Card card) throws CustomException{
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
