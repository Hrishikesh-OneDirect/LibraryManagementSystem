package com.example.demo.service;

import com.example.demo.dto.BookDTO;
import com.example.demo.entities.Book;
import com.example.demo.exceptions.CustomException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface BookService {
    public List<Book> getAllBooks();
    public ResponseEntity<?> addBook(@RequestBody BookDTO book) throws CustomException;
    public ResponseEntity<?> getBookById(@PathVariable int bookId) throws CustomException;
    public ResponseEntity<?> deleteBook(@RequestBody Book book) throws CustomException;
    public ResponseEntity<?> getBookByTitle(@RequestBody Book book) throws CustomException;
}
