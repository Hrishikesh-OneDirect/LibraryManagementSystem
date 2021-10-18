package com.example.demo.controllers;

import com.example.demo.entities.Book;
import com.example.demo.entities.Publisher;
import com.example.demo.exceptions.CustomException;
import com.example.demo.repositories.BookRepo;
import com.example.demo.repositories.PublisherRepo;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    BookService bookService;
    @GetMapping("/getAllBooks")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @PostMapping("/addBook")
    public ResponseEntity<?> addBook(@RequestBody Book book) throws CustomException{
        return bookService.addBook(book);
    }

    @GetMapping("/getBookById/{bookId}")
    public ResponseEntity<?> getBookById(@PathVariable int bookId) throws CustomException{
        return bookService.getBookById(bookId);
    }

    @DeleteMapping("/deleteBook")
    public ResponseEntity<?> deleteBook(@RequestBody Book book) throws CustomException{
        return bookService.deleteBook(book);

    }

    @PostMapping("/getBookByTitle")
    public ResponseEntity<?> getBookByTitle(@RequestBody Book book) throws CustomException{
        return bookService.getBookByTitle(book);
    }

}
