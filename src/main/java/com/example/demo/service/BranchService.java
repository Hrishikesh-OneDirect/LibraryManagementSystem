package com.example.demo.service;

import com.example.demo.entities.Branch;
import com.example.demo.exceptions.CustomException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface BranchService {
    public List<Branch> getAllBranches();
    public ResponseEntity<?> getBranchById(@PathVariable("branchId") int id) throws CustomException;
    ResponseEntity<?> addBranch(@RequestBody Branch branch) throws CustomException;
    public ResponseEntity<?> deleteBranch(@RequestBody Branch branch);
}
