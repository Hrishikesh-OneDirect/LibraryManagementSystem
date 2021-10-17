package com.example.demo.entities;

import com.example.demo.id.BookCopiesID;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="Book_Copies")
@IdClass(BookCopiesID.class)
public class BookCopies {
    @Override
    public String toString() {
        return "BookCopies{" +
                "bookId=" + bookId +
                ", branchId=" + branchId +
                ", noOfCopies=" + noOfCopies +
                '}';
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public int getNoOfCopies() {
        return noOfCopies;
    }

    public void setNoOfCopies(int noOfCopies) {
        this.noOfCopies = noOfCopies;
    }

    @Id
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Book.class)
    @JoinColumn(name = "book_id")
    private int bookId;

    @Id
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Branch.class)
    @JoinColumn(name = "branch_id")
    private int branchId;

    @Column(name = "no_of_copies")
    private int noOfCopies;


}
