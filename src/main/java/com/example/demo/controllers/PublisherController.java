package com.example.demo.controllers;

import com.example.demo.exceptions.CustomException;
import com.example.demo.entities.Publisher;
import com.example.demo.repositories.PublisherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PublisherController {

    @Autowired
    PublisherRepo publisherRepo;

    @PostMapping("/addPublisher")
    public ResponseEntity<?> insertPublisher(@RequestBody Publisher publisher) throws CustomException {
        ResponseEntity responseEntity;
        try {
            publisherRepo.save(publisher);
            responseEntity = new ResponseEntity("Publisher was added successfully", HttpStatus.OK);
        } catch (Exception e) {
            throw new CustomException("Invalid name");
        }
        return responseEntity;
    }

    @GetMapping("/getAllPublishers")
    public List<Publisher> getPublishers() {
        return publisherRepo.findAll();
    }

    @GetMapping("/getPublisherByName/{publisherName}")
    public ResponseEntity<?> getPublisherByName(@PathVariable("publisherName") String name) throws CustomException {
        Optional<Publisher> publisher = publisherRepo.findById(name);
        ResponseEntity responseEntity;
            if (publisher.isPresent()) {
                responseEntity = new ResponseEntity(publisher.get(), HttpStatus.OK);
            } else {
                throw new CustomException("Publisher Name not found");
            }
        return responseEntity;
    }

    @DeleteMapping("/deletePublisher")
    public ResponseEntity<?> deletePublisher(@RequestBody Publisher publisher) throws CustomException{
        ResponseEntity responseEntity;
        try {
            publisherRepo.deleteById(publisher.getName());
            responseEntity = new ResponseEntity("Publisher was deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            throw new CustomException("Publisher name is invalid");
        }
        return responseEntity;

    }
}
