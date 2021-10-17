package com.example.demo.repositories;

import com.example.demo.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepo extends JpaRepository<Book,Integer> {
    @Query("SELECT b from Book b where b.title =:title ")
    List<Book> findByTitle(@Param("title") String title);
}
