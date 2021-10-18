package com.example.demo.id;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class BookCopiesID implements Serializable {
    private int bookId;
    private int branchId;

    @Override
    public String toString() {
        return "BookCopiesID{" +
                "bookId=" + bookId +
                ", branchId=" + branchId +
                '}';
    }

    public BookCopiesID(){}
    public BookCopiesID(int bookId,int branchId){
        this.bookId = bookId;
        this.branchId = branchId;
    }
}
