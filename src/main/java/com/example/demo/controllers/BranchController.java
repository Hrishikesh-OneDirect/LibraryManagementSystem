package com.example.demo.controllers;

import com.example.demo.entities.Branch;
import com.example.demo.entities.Card;
import com.example.demo.entities.Publisher;
import com.example.demo.exceptions.CustomException;
import com.example.demo.repositories.BranchRepo;
import com.example.demo.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BranchController {
    @Autowired
    BranchService branchService;
    @GetMapping("/getAllBranches")
    public List<Branch> getAllBranches(){
        return branchService.getAllBranches();
    }

    @GetMapping("/getBranchById/{branchId}")
    public ResponseEntity<?> getBranchById(@PathVariable("branchId") int id) throws CustomException {
        return branchService.getBranchById(id);
    }

    @PostMapping("/addBranch")
    ResponseEntity<?> addBranch(@RequestBody Branch branch) throws CustomException {
        return branchService.addBranch(branch);
    }

    @DeleteMapping("/deleteBranch")
    public ResponseEntity<?> deleteBranch(@RequestBody Branch branch){
        return branchService.deleteBranch(branch);

    }
}
