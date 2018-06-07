package com.example.demo.service;

import com.example.demo.model.Dependent;
import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeAndDependents;
import com.example.demo.repository.DependentRepository;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DependentRepository dependentRepository;

    @Override
    public Boolean save(EmployeeAndDependents employeeAndDependents) {

        try {
            Employee  employee = employeeRepository.save(employeeAndDependents.getEmployee());

            for (Dependent dependent : employeeAndDependents.getDependents()) {
                dependentRepository.save(dependent.setParentId(employee.getId()));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public @Override List<EmployeeAndDependents> findByLastName(String employeeLastName) {

        List<Employee> employees = employeeRepository.findByLastName(employeeLastName);
        List<EmployeeAndDependents> employeeAndDependents = new ArrayList<>();

        for (Employee employee : employees) {
            employeeAndDependents.add(
                    new EmployeeAndDependents()
                    .setEmployee(employee)
                    .setDependents(dependentRepository.findByParentId(employee.getId()))
            );
        }
        return employeeAndDependents;
    }
}
