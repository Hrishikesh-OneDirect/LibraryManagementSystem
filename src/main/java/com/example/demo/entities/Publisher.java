package com.example.demo.entities;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name="Publisher")
public class Publisher {
    @Id
    private String name;
    private String address;
    private String phone;

    @OneToMany(mappedBy = "publisher",orphanRemoval=true)
    private Set<Book> book;

    @Override
    public String toString() {
        return "Publisher{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
