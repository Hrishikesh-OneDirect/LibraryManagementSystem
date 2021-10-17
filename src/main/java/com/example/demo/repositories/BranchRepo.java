package com.example.demo.repositories;

import com.example.demo.entities.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepo extends JpaRepository<Branch,Integer> {
}
