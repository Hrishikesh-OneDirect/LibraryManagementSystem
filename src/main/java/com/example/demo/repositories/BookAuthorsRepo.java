package com.example.demo.repositories;

import com.example.demo.entities.BookAuthors;
import com.example.demo.id.BookAuthorsID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookAuthorsRepo extends JpaRepository<BookAuthors, BookAuthorsID> {
//    @Query(value = "Delete * FROM Book_Authors b WHERE b.author_name=?1")
//    void deleteAuthor(String authorName);
}
