package com.example.demo.service;

import com.example.demo.entities.BookLending;
import com.example.demo.exceptions.CustomException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LendingService {
    public List<BookLending> getLendingInfo();
    public ResponseEntity<?> lendBook(BookLending lending) throws CustomException;
    public ResponseEntity<?> returnBook(int id) throws CustomException;
}
