package com.example.demo.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.util.Date;

@Entity
@Table(name="Book")
public class Book {
    @Id()
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="book_id")
    private int bookId;

    private String title;
    @JoinColumn(name="publisher_name",referencedColumnName = "name")
    private String publisherName;
    @Column(name="pub_year")
    private Date publisherYear;

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", publisherName='" + publisherName + '\'' +
                ", publisherYear=" + publisherYear +
                '}';
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public Date getPublisherYear() {
        return publisherYear;
    }

    public void setPublisherYear(Date publisherYear) {
        this.publisherYear = publisherYear;
    }
}
