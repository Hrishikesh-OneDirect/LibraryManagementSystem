package com.example.demo.entities;

import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="Publisher")
public class Publisher {
    @Id
    @NotBlank(message = "Name cannot be blank")
    private String name;

    private String address;
    private String phone;

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
