package com.example.demo.entities;

import com.example.demo.id.BookAuthorsID;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity @IdClass(BookAuthorsID.class)
@Table(name="Book_Authors")
public class BookAuthors {
    @Id
    @JoinColumn(name = "book_id", referencedColumnName = "bookId")
    @NotBlank(message = "Book ID cannot be blank")
    private int book_id;

    @Override
    public String toString() {
        return "BookAuthors{" +
                "book_id=" + book_id +
                ", authorName='" + authorName + '\'' +
                '}';
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Id
    @Column(name="author_name")
    @NotBlank(message = "Author name cannot be blank")
    private String authorName;


}
