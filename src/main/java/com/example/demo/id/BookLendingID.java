package com.example.demo.id;
import java.io.Serializable;
import java.util.Date;

public class BookLendingID implements Serializable {
    private int bookId;
    private int branchId;
    private int cardNo;

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

    @Override
    public String toString() {
        return "BookLendingID{" +
                "bookId=" + bookId +
                ", branchId=" + branchId +
                ", cardNo=" + cardNo +
                '}';
    }
}
