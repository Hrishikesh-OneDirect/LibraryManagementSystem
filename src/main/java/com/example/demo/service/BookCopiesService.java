package com.example.demo.service;

import com.example.demo.entities.BookCopies;
import com.example.demo.exceptions.CustomException;
import com.example.demo.id.BookCopiesID;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BookCopiesService {
    public List<BookCopies> getAllCopies();
    public BookCopies getCopy(BookCopiesID id) throws CustomException;
    public void modifyBookCopiesCount(BookCopies bookCopies,Boolean shouldIncrement);
    public ResponseEntity<?> addCopies(BookCopies bookCopies) throws CustomException;
    public ResponseEntity<?> getCopies(BookCopiesID id) throws CustomException;
}
