package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

public class EmployeeAndDependents {


    @JsonProperty("dependents")
    private List<Dependent> Dependents;

    @JsonProperty("employee")
    private Employee employee;

    @JsonGetter("employee")
    public Employee getEmployee() {
        return employee;
    }

    @JsonSetter("employee")
    public EmployeeAndDependents setEmployee(Employee employee) {
        this.employee = employee;
        return this;
    }

    @JsonGetter("dependents")
    public List<Dependent> getDependents() {
        return Dependents;
    }

    @JsonSetter("dependents")
    public EmployeeAndDependents setDependents(List<Dependent> dependents) {
        Dependents = dependents;
        return this;
    }
}
