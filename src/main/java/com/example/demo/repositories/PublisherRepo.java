package com.example.demo.repositories;

import com.example.demo.entities.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepo extends JpaRepository<Publisher,String> {

}
