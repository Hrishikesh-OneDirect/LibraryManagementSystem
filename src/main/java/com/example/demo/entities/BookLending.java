package com.example.demo.entities;

import com.example.demo.id.BookLendingID;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.util.Date;

@Entity
@Table(name="Book_lending")
//@IdClass(BookLendingID.class)
public class BookLending {
    public int getId() {
        return id;
    }

    @Override
    public String
    toString() {
        return "BookLending{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", branchId=" + branchId +
                ", cardNo=" + cardNo +
                ", checkoutDate=" + checkoutDate +
                ", dueDate=" + dueDate +
                ", status=" + status +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Transient
    @JsonProperty
    private int bookId;
    @Transient
    @JsonProperty
    private int branchId;
    @Transient
    @JsonProperty
    private int cardNo;

    @JsonIgnore
    @ManyToOne( targetEntity = Book.class)
    @JoinColumn(name = "book_id")
    private Book book;

    @JsonIgnore
    @ManyToOne( targetEntity = Branch.class)
    @JoinColumn(name = "branch_id")
    private Branch branch;

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

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @JsonIgnore
    @ManyToOne( targetEntity = Card.class)
    @JoinColumn(name="card_no")
    private Card card;

    @Column(name="date_out")
    private Date checkoutDate;
    @Column(name="due_date")
    private Date dueDate;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    private int status;

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

    public int getCardNo() {
        return cardNo;
    }

    public void setCardNo(int cardNo) {
        this.cardNo = cardNo;
    }

    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}
