package com.example.demo.repositories;

import com.example.demo.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepo extends JpaRepository<Card,Integer> {
}
