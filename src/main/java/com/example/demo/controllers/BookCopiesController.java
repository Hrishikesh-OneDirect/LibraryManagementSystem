package com.example.demo.controllers;

import com.example.demo.entities.BookCopies;
import com.example.demo.entities.Publisher;
import com.example.demo.exceptions.CustomException;
import com.example.demo.id.BookCopiesID;
import com.example.demo.repositories.BookCopiesRepo;
import com.example.demo.service.BookCopiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookCopiesController {
    @Autowired
    BookCopiesService bookCopiesService;

    @GetMapping("/getAllCopies")
    public List<BookCopies> getAllCopies(){
        return bookCopiesService.getAllCopies();
    }

    @PostMapping("/addCopiesForBook")
    public ResponseEntity<?> addCopiesForBook(@RequestBody BookCopies bookCopies) throws CustomException{
        return bookCopiesService.addCopies(bookCopies);
    }

    @GetMapping("/getCopies/{branchId}/{bookId}")
    public ResponseEntity<?> getCopies(@PathVariable("branchId") int branchId, @PathVariable("bookId") int bookId) throws CustomException {
        return bookCopiesService.getCopies(new BookCopiesID(branchId,bookId));
    }


}
