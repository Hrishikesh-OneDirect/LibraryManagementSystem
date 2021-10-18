package com.example.demo.service.impl;

import com.example.demo.entities.Book;
import com.example.demo.exceptions.CustomException;
import com.example.demo.repositories.BookRepo;
import com.example.demo.repositories.PublisherRepo;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepo bookRepo;
    @Autowired
    PublisherRepo publisherRepo;
    @Override
    public List<Book> getAllBooks() {
        List<Book> bookList = bookRepo.findAll();
        for(Book book:bookList){
            book.setPublisherName(book.getPublisher().getName());
        }
        return bookList;
    }

    @Override
    public ResponseEntity<?> addBook(Book book) throws CustomException {
        try{
            book.setPublisher(publisherRepo.getById(book.getPublisherName()));
            bookRepo.save(book);
            return new ResponseEntity<>("Book added Successfully", HttpStatus.OK);
        }catch(Exception e){
            System.out.println("Exception...."+e);
            throw new CustomException("Invalid publisher name");
        }
    }

    @Override
    public ResponseEntity<?> getBookById(int bookId) throws CustomException {
        Optional<Book> book = bookRepo.findById(bookId);
        if(book.isPresent()){
            Book returnBook = book.get();
            returnBook.setPublisherName(returnBook.getPublisher().getName());
            return new ResponseEntity<>(book.get(),HttpStatus.OK);
        }else{
            throw new CustomException("Invalid book ID");
        }
    }

    @Override
    public ResponseEntity<?> deleteBook(Book book) throws CustomException {
        ResponseEntity responseEntity;
        try {
            bookRepo.deleteById(book.getBookId());
            responseEntity = new ResponseEntity("Book was deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            throw new CustomException("Book id is invalid");
        }
        return responseEntity;
    }

    @Override
    public ResponseEntity<?> getBookByTitle(Book book) throws CustomException {
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
