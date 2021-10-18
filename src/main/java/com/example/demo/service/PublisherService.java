package com.example.demo.service;

import com.example.demo.entities.Publisher;
import com.example.demo.exceptions.CustomException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PublisherService {
    public ResponseEntity<?> insertPublisher(@RequestBody Publisher publisher) throws CustomException;
    public List<Publisher> getPublishers();
    public ResponseEntity<?> getPublisherByName(@PathVariable("publisherName") String name) throws CustomException;
    public ResponseEntity<?> deletePublisher(@RequestBody Publisher publisher) throws CustomException;
}
