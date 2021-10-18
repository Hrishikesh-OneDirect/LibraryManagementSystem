package com.example.demo.service.impl;

import com.example.demo.entities.Publisher;
import com.example.demo.exceptions.CustomException;
import com.example.demo.repositories.PublisherRepo;
import com.example.demo.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublisherServiceImpl implements PublisherService {
    @Autowired
    PublisherRepo publisherRepo;
    @Override
    public ResponseEntity<?> insertPublisher(Publisher publisher) throws CustomException {
        ResponseEntity responseEntity;
        try {
            publisherRepo.save(publisher);
            responseEntity = new ResponseEntity("Publisher was added successfully", HttpStatus.OK);
        } catch (Exception e) {
            throw new CustomException("Invalid name");
        }
        return responseEntity;
    }

    @Override
    public List<Publisher> getPublishers() {
        return publisherRepo.findAll();
    }

    @Override
    public ResponseEntity<?> getPublisherByName(String name) throws CustomException {
        Optional<Publisher> publisher = publisherRepo.findById(name);
        ResponseEntity responseEntity;
        if (publisher.isPresent()) {
            responseEntity = new ResponseEntity(publisher.get(), HttpStatus.OK);
        } else {
            throw new CustomException("Publisher Name not found");
        }
        return responseEntity;
    }

    @Override
    public ResponseEntity<?> deletePublisher(Publisher publisher) throws CustomException {
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
