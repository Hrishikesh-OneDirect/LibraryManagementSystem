package com.example.demo.service.impl;

import com.example.demo.entities.BookCopies;
import com.example.demo.exceptions.CustomException;
import com.example.demo.id.BookCopiesID;
import com.example.demo.repositories.BookCopiesRepo;
import com.example.demo.service.BookCopiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookCopiesServiceImpl implements BookCopiesService {
    @Autowired
    BookCopiesRepo copiesRepo;
    @Override
    public List<BookCopies> getAllCopies() {
        return copiesRepo.findAll();
    }

    public BookCopies getCopy(BookCopiesID id) throws CustomException {
        Optional<BookCopies> optionalCopy = copiesRepo.findById(id);
        BookCopies bookCopies = null;
        if (optionalCopy.isPresent()){
            return optionalCopy.get();
        }else{
            throw new CustomException(" Book does not exist in the given branch");
        }
    }
    public void modifyBookCopiesCount(BookCopies bookCopies,Boolean shouldIncrement){
            if (shouldIncrement){
                bookCopies.setNoOfCopies(bookCopies.getNoOfCopies()+1);

            }else{
                bookCopies.setNoOfCopies(bookCopies.getNoOfCopies()-1);
            }
            copiesRepo.save(bookCopies);
    }

    @Override
    public ResponseEntity<?> addCopies(BookCopies bookCopies) throws CustomException{
        try {
            this.copiesRepo.save(bookCopies);
            return new ResponseEntity<>("Copies for book added successfully",HttpStatus.OK);
        }catch (Exception e){
            throw new CustomException("BookID / branchID invalid");
        }
    }

    @Override
    public ResponseEntity<?> getCopies(BookCopiesID id) throws CustomException {
        Optional<BookCopies> bookCopies = copiesRepo.findById(id);
        if(bookCopies.isPresent()){
            return new ResponseEntity<>(bookCopies.get(), HttpStatus.OK);
        }else{
            throw new CustomException("Book ID/ Branch ID not found");
        }
    }

}
