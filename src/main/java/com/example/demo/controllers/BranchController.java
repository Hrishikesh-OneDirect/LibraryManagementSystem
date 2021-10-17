package com.example.demo.controllers;

import com.example.demo.entities.Branch;
import com.example.demo.entities.Card;
import com.example.demo.entities.Publisher;
import com.example.demo.exceptions.CustomException;
import com.example.demo.repositories.BranchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BranchController {
    @Autowired
    BranchRepo branchRepo;
    @GetMapping("/getAllBranches")
    public List<Branch> getAllBranches(){
        return branchRepo.findAll();
    }

    @GetMapping("/getBranchById/{branchId}")
    public ResponseEntity<?> getBranchById(@PathVariable("branchId") int id) throws CustomException {
        Optional<Branch> branch = branchRepo.findById(id);
        ResponseEntity responseEntity;
        if (branch.isPresent()) {
            responseEntity = new ResponseEntity(branch.get(), HttpStatus.OK);
        } else {
            throw new CustomException("Branch ID not found");
        }
        return responseEntity;
    }

    @PostMapping("/addBranch")
    ResponseEntity<?> addBranch(@RequestBody Branch branch) throws CustomException {
        if(branch.getBranchName()=="" || branch.getBranchName()==null ||
        branch.getAddress()==null || branch.getAddress()==""
        ){
            throw new CustomException("Branch Name/Address is invalid");
        }
        branchRepo.save(branch);
        return new ResponseEntity<>("Branch saved successfully", HttpStatus.OK);
    }

    @DeleteMapping("/deleteBranch")
    public ResponseEntity<?> deleteBranch(@RequestBody Branch branch){
        ResponseEntity responseEntity;
        try {
            branchRepo.deleteById(branch.getBranchID());
            responseEntity = new ResponseEntity("Branch was deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            responseEntity = new ResponseEntity("Branch ID is null/invalid", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;

    }
}
