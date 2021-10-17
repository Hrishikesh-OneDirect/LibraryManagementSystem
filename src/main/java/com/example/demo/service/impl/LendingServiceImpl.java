package com.example.demo.service.impl;

import com.example.demo.entities.BookCopies;
import com.example.demo.entities.BookLending;
import com.example.demo.exceptions.CustomException;
import com.example.demo.id.BookCopiesID;
import com.example.demo.repositories.BookLendingRepo;
import com.example.demo.service.BookCopiesService;
import com.example.demo.service.LendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LendingServiceImpl implements LendingService {
    @Autowired
    BookLendingRepo bookLendingRepo;

    @Autowired
    BookCopiesService bookCopiesService;

    @Override
    public List<BookLending> getLendingInfo() {
        return bookLendingRepo.findAll();
    }

    @Override
    public ResponseEntity<?> lendBook(BookLending bookLending) throws CustomException {
        BookCopies bookCopies;
        bookCopies = bookCopiesService.getCopy( new BookCopiesID(bookLending.getBookId(), bookLending.getBranchId()));
        if(bookCopies!=null){
            if (bookCopies.getNoOfCopies()>0){
                if(bookLending.getDueDate()==null || bookLending.getCheckoutDate()==null || bookLending.getDueDate().before(bookLending.getCheckoutDate())){
                    throw new CustomException("Invalid due/checkout dates");
                }
                bookLending.setStatus(0);
                try{
                    BookLending bookLending1 = bookLendingRepo.save(bookLending);
                    bookCopiesService.modifyBookCopiesCount(bookCopies,false);
                    return new ResponseEntity<>(bookLending1, HttpStatus.OK);

                }catch (Exception e){
                    throw new CustomException("Card number invalid");
                }


            }else{
                throw new CustomException("No copies of the book left");
            }
        }else{
            throw new CustomException("Book not found");
        }
    }

    @Override
    public ResponseEntity<?> returnBook(int id) throws CustomException {
        Optional<BookLending> optionalBookLending= bookLendingRepo.findById(id);
        if (optionalBookLending.isPresent()){
            BookLending bookLending = optionalBookLending.get();
            bookLending.setStatus(1);
            bookLendingRepo.save(bookLending);
            BookCopies bookCopies = bookCopiesService.getCopy(new BookCopiesID(bookLending.getBookId(),bookLending.getBranchId()));
                bookCopiesService.modifyBookCopiesCount(bookCopies,true);
            return new ResponseEntity<>("Book returned successfully", HttpStatus.OK);

        }else{
            throw new CustomException("Book Lending record not found");
        }
    }


}
