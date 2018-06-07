package com.example.demo.repository;

import java.util.List;
import com.example.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByLastName(String name);

    @Override
    List<Employee> findAll();

    <S extends Employee> boolean existsById(Long id);

    <S extends Employee> S save(S employee);
}
