package com.example.demo.service.impl;

import com.example.demo.entities.Branch;
import com.example.demo.exceptions.CustomException;
import com.example.demo.repositories.BranchRepo;
import com.example.demo.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BranchServiceImpl implements BranchService {
    @Autowired
    BranchRepo branchRepo;
    @Override
    public List<Branch> getAllBranches() {
        return branchRepo.findAll();
    }

    @Override
    public ResponseEntity<?> getBranchById(int id) throws CustomException {
        Optional<Branch> branch = branchRepo.findById(id);
        ResponseEntity responseEntity;
        if (branch.isPresent()) {
            responseEntity = new ResponseEntity(branch.get(), HttpStatus.OK);
        } else {
            throw new CustomException("Branch ID not found");
        }
        return responseEntity;
    }

    @Override
    public ResponseEntity<?> addBranch(Branch branch) throws CustomException {
        if(branch.getBranchName()=="" || branch.getBranchName()==null ||
                branch.getAddress()==null || branch.getAddress()==""
        ){
            throw new CustomException("Branch Name/Address is invalid");
        }
        branchRepo.save(branch);
        return new ResponseEntity<>("Branch saved successfully", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> deleteBranch(Branch branch) {
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
