package com.example.demo.repositories;

import com.example.demo.entities.BookCopies;
import com.example.demo.id.BookCopiesID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCopiesRepo extends JpaRepository<BookCopies, BookCopiesID> {
}
