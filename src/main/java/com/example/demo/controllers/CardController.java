package com.example.demo.controllers;

import com.example.demo.entities.Card;
import com.example.demo.exceptions.CustomException;
import com.example.demo.repositories.CardRepo;
import com.example.demo.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CardController {
@Autowired
    CardService cardService;

    @GetMapping("/getAllCards")
    public List<Card> getAllCards(){
        return cardService.getAllCards();
    }

    @PostMapping("/addCard")
    public ResponseEntity<?> addCard(@RequestBody Card card) throws CustomException{
        return cardService.addCard(card);
    }

    @DeleteMapping("/deleteCard")
    public ResponseEntity<?> deleteCard(@RequestBody Card card) throws CustomException{
        return cardService.deleteCard(card);
    }
}
