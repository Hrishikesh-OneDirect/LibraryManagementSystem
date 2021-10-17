package com.example.demo.entities;

import com.example.demo.id.BookLendingID;

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

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Book.class)
    @JoinColumn(name = "book_id")
    private int bookId;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Branch.class)
    @JoinColumn(name = "branch_id")
    private int branchId;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Card.class)
    @JoinColumn(name="card_no")
    private int cardNo;

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
