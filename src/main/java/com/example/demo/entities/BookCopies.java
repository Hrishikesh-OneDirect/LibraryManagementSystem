package com.example.demo.entities;

import com.example.demo.id.BookCopiesID;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="Book_Copies")
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

    @Transient
    @JsonProperty
    private int bookId;
    @Transient
    @JsonProperty
    private int branchId;

    @JsonIgnore
    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name="bookId", column = @Column(name="BOOK_ID")),
            @AttributeOverride(name="branchId", column = @Column(name="BRANCH_ID"))
    })
    private BookCopiesID bookCopiesID;

    @JsonIgnore
    @MapsId("bookId")
    @ManyToOne( targetEntity = Book.class)
    private Book book;

    public BookCopiesID getBookCopiesID() {
        return bookCopiesID;
    }

    public void setBookCopiesID(BookCopiesID bookCopiesID) {
        this.bookCopiesID = bookCopiesID;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    @JsonIgnore
    @MapsId("branchId")
    @ManyToOne( targetEntity = Branch.class)
    private Branch branch;


    @Column(name = "no_of_copies")
    private int noOfCopies;



}
