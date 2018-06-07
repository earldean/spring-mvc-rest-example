package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dependent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * primary key of Employee who this dependent belongs to
     */

    @JsonIgnore
    private long parentId;

    private String firstName;

    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public Dependent setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Dependent setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public long getParentId() {
        return parentId;
    }

    public Dependent setParentId(long parentId) {
        this.parentId = parentId;
        return this;
    }
}
