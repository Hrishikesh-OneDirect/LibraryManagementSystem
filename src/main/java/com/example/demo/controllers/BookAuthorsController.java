package com.example.demo.controllers;

import com.example.demo.dto.DeleteAuthorDTO;
import com.example.demo.entities.Book;
import com.example.demo.entities.BookAuthors;
import com.example.demo.exceptions.CustomException;
import com.example.demo.repositories.BookAuthorsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookAuthorsController {
    @Autowired
    BookAuthorsRepo bookAuthorsRepo;

    @GetMapping("/getAllAuthors")
    public List<BookAuthors> getAllAuthors(){
        return bookAuthorsRepo.findAll();
    }

    @PostMapping("/addAuthor")
    public ResponseEntity<?> addAuthor(@RequestBody BookAuthors bookAuthor) throws CustomException{
        try{
            bookAuthorsRepo.save(bookAuthor);
            return new ResponseEntity<>("Author added successfully", HttpStatus.OK);
        }catch(Exception e){
            System.out.println("Exception "+e);
            throw new CustomException("Invalid Author Name/ book ID");
        }
    }

//    @PostMapping("/deleteAuthor")
//    public ResponseEntity<?> deleteAuthor(@RequestBody DeleteAuthorDTO deleteAuthorDTO) throws CustomException{
//        try{
//            bookAuthorsRepo.deleteAuthor(deleteAuthorDTO.getAuthor_name());
//            return new ResponseEntity<>("Author deleted",HttpStatus.OK);
//        }catch (Exception e){
//            throw new CustomException("Invalid author name");
//        }
//    }
}
