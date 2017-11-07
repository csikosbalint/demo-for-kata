package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue
    Long id;

    String lname;
    String fname;

	public void setName(String name) {
        this.lname = name;
    }

    public void setFName(String name) {
        this.fname = name;
    }

    public Long getId() { return id; }

    public String getFname() {
        return this.fname;
    }
}