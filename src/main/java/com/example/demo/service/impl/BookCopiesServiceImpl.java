package com.example.demo.service.impl;

import com.example.demo.entities.Book;
import com.example.demo.entities.BookCopies;
import com.example.demo.entities.Branch;
import com.example.demo.exceptions.CustomException;
import com.example.demo.id.BookCopiesID;
import com.example.demo.repositories.BookCopiesRepo;
import com.example.demo.repositories.BookRepo;
import com.example.demo.repositories.BranchRepo;
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
    @Autowired
    BookRepo bookRepo;
    @Autowired
    BranchRepo branchRepo;
    @Override
    public List<BookCopies> getAllCopies() {
        List<BookCopies> bookCopiesList = copiesRepo.findAll();
        for(BookCopies bookCopies:bookCopiesList){
            bookCopies.setBookId(bookCopies.getBook().getBookId());
            bookCopies.setBranchId(bookCopies.getBranch().getBranchID());
        }
        return bookCopiesList;
    }

    public BookCopies getCopy(BookCopiesID id) throws CustomException {
        Optional<BookCopies> bookCopies = copiesRepo.findById(id);
        if(bookCopies.isPresent()){
            BookCopies bookCopies1 =bookCopies.get();
            bookCopies1.setBookId(bookCopies1.getBook().getBookId());
            bookCopies1.setBranchId(bookCopies1.getBranch().getBranchID());
            return bookCopies1;
        }else{
            throw new CustomException("Book does not exist in the given branch");
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
            Book book = bookRepo.getById(bookCopies.getBookId());
            Branch branch = branchRepo.getById(bookCopies.getBranchId());
            BookCopiesID bookCopiesID = new BookCopiesID(book.getBookId(),branch.getBranchID());
            bookCopies.setBook(book);
            bookCopies.setBranch(branch);
            bookCopies.setBookCopiesID(bookCopiesID);
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
            BookCopies bookCopies1 =bookCopies.get();
            bookCopies1.setBookId(bookCopies1.getBook().getBookId());
            bookCopies1.setBranchId(bookCopies1.getBranch().getBranchID());
            return new ResponseEntity<>(bookCopies1, HttpStatus.OK);
        }else{
            throw new CustomException("Book ID/ Branch ID not found");
        }
    }

}
