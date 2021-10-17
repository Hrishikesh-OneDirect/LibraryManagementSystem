package com.example.demo.id;

import java.io.Serializable;

public class BookCopiesID implements Serializable {
    private int bookId;
    private int branchId;
    public BookCopiesID(){}
    public BookCopiesID(int bookId,int branchId){
        this.bookId = bookId;
        this.branchId = branchId;
    }
}
