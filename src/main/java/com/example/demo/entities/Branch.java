package com.example.demo.entities;

import javax.persistence.*;

@Entity
@Table(name="Library_Branch")
public class Branch {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="branch_id")
    private int branchID;
    @Column(name="branch_name")
    private String branchName;
    private String address;

    @Override
    public String toString() {
        return "Branch{" +
                "branchID=" + branchID +
                ", branchName='" + branchName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public int getBranchID() {
        return branchID;
    }

    public void setBranchID(int branchID) {
        this.branchID = branchID;
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
