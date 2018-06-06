package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Employee;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.repository.query.Param;


@RepositoryRestResource(collectionResourceRel = "employee", path="employee")
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

    List<Employee> findByLastName(@Param("lastName") String lastName);
}
