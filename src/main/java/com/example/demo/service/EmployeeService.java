package com.example.demo.service;

import com.example.demo.model.EmployeeAndDependents;

import java.util.List;


public interface EmployeeService {

    /**
     * Save Employee
     * @param employeeAndDependents Employee and their dependents to save
     * @return
     */
    Boolean save(EmployeeAndDependents employeeAndDependents);

    /**
     * Get All employes with last name and their associated dependents
     * @param employeeLastName Last name to query for
     * @return
     */
    List<EmployeeAndDependents> findByLastName(String employeeLastName);
}
