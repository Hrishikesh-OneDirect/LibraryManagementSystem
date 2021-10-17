package com.example.demo.repositories;

import com.example.demo.entities.BookLending;
import com.example.demo.id.BookLendingID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookLendingRepo extends JpaRepository<BookLending, Integer> {
}
