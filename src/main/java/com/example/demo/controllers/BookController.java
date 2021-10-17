package com.example.demo.controllers;

import com.example.demo.entities.Book;
import com.example.demo.entities.Publisher;
import com.example.demo.exceptions.CustomException;
import com.example.demo.repositories.BookRepo;
import com.example.demo.repositories.PublisherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    BookRepo bookRepo;
    @Autowired
    PublisherRepo publisherRepo;
    @GetMapping("/getAllBooks")
    public List<Book> getAllBooks(){
        List<Book> bookList = bookRepo.findAll();
        for(Book book:bookList){
            book.setPublisherName(book.getPublisher().getName());
        }
        return bookList;
    }

    @PostMapping("/addBook")
    public ResponseEntity<?> addBook(@RequestBody Book book) throws CustomException{
        try{
            book.setPublisher(publisherRepo.getById(book.getPublisherName()));
            bookRepo.save(book);
            return new ResponseEntity<>("Book added Successfully", HttpStatus.OK);
        }catch(Exception e){
            System.out.println("Exception...."+e);
            throw new CustomException("Invalid publisher name");
        }
    }

    @GetMapping("/getBookById/{bookId}")
    public ResponseEntity<?> getBookById(@PathVariable int bookId) throws CustomException{
        Optional<Book> book = bookRepo.findById(bookId);
        if(book.isPresent()){
            Book returnBook = book.get();
            returnBook.setPublisherName(returnBook.getPublisher().getName());
            return new ResponseEntity<>(book.get(),HttpStatus.OK);
        }else{
            throw new CustomException("Invalid book ID");
        }
    }

    @DeleteMapping("/deleteBook")
    public ResponseEntity<?> deleteBook(@RequestBody Book book) throws CustomException{
        ResponseEntity responseEntity;
        try {
            bookRepo.deleteById(book.getBookId());
            responseEntity = new ResponseEntity("Book was deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            throw new CustomException("Book id is invalid");
        }
        return responseEntity;

    }

    @PostMapping("/getBookByTitle")
    public ResponseEntity<?> getBookByTitle(@RequestBody Book book) throws CustomException{
            List<Book> bookList = bookRepo.findByTitle(book.getTitle());
            if (bookList.size()==0){
                throw new CustomException("Book not found");
            }
        for(Book book1:bookList){
            book1.setPublisherName(book1.getPublisher().getName());
        }
            return new ResponseEntity<>(bookList,HttpStatus.OK);
    }

}
