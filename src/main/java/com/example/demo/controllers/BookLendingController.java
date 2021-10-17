package com.example.demo.controllers;

import com.example.demo.entities.BookLending;
import com.example.demo.exceptions.CustomException;
import com.example.demo.service.LendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookLendingController {
    @Autowired
    LendingService lendingService;
    @GetMapping("/getAllLendingInfo")
    public List<BookLending> getAllLendingInfo(){
        return lendingService.getLendingInfo();
    }
    @PostMapping("/lendBook")
    public ResponseEntity<?> lendBook(@RequestBody BookLending bookLending) throws CustomException {
            return lendingService.lendBook(bookLending);

    }
    @PostMapping("/returnBook")
    public ResponseEntity<?> returnBook(@RequestBody BookLending bookLending) throws CustomException{
        return lendingService.returnBook(bookLending.getId());
    }
}
