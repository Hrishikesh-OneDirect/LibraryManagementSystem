package com.example.demo.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Library_Branch")
public class Branch {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="branch_id")
    private int branchId;
    @Column(name="branch_name")
    private String branchName;
    private String address;

    @OneToMany(mappedBy = "branch",orphanRemoval=true)
    private Set<BookLending> bookLendings;

    @OneToMany(mappedBy = "branch",orphanRemoval=true)
    private Set<BookCopies> bookCopies;

    @Override
    public String toString() {
        return "Branch{" +
                "branchID=" + branchId +
                ", branchName='" + branchName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public int getBranchID() {
        return branchId;
    }

    public void setBranchID(int branchID) {
        this.branchId = branchID;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
