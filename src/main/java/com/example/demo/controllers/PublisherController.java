package com.example.demo.controllers;

import com.example.demo.exceptions.CustomException;
import com.example.demo.entities.Publisher;
import com.example.demo.repositories.PublisherRepo;
import com.example.demo.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PublisherController {

    @Autowired
    PublisherService publisherService;

    @PostMapping("/addPublisher")
    public ResponseEntity<?> insertPublisher(@RequestBody Publisher publisher) throws CustomException {
        return publisherService.insertPublisher(publisher);
    }

    @GetMapping("/getAllPublishers")
    public List<Publisher> getPublishers() {
        return publisherService.getPublishers();
    }

    @GetMapping("/getPublisherByName/{publisherName}")
    public ResponseEntity<?> getPublisherByName(@PathVariable("publisherName") String name) throws CustomException {
        return publisherService.getPublisherByName(name);
    }

    @DeleteMapping("/deletePublisher")
    public ResponseEntity<?> deletePublisher(@RequestBody Publisher publisher) throws CustomException{
        return publisherService.deletePublisher(publisher);

    }
}
