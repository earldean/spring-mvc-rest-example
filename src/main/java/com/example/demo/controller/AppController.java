package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.EmployeeAndDependents;
import com.example.demo.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AppController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * Save Employee and thier dependents
     * @param employeeAndDependents @See EmployeeAndDependents
     * @return ResponsteEntity<?>
     */

    @PostMapping("api/employee")
    public ResponseEntity<?> saveEmployee(@RequestBody EmployeeAndDependents employeeAndDependents) {

        boolean successfullSave = employeeService.save(employeeAndDependents);

        if (successfullSave) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("api/employee/search")
    public List<EmployeeAndDependents> findByLastName(@RequestParam(value="name") String name) {
        return employeeService.findByLastName(name);
    }

}
