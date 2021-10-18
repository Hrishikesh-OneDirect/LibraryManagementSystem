package com.example.demo.service;

import com.example.demo.entities.Card;
import com.example.demo.exceptions.CustomException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CardService {
    public List<Card> getAllCards();
    public ResponseEntity<?> addCard(@RequestBody Card card) throws CustomException;
    public ResponseEntity<?> deleteCard(@RequestBody Card card) throws CustomException;
}
