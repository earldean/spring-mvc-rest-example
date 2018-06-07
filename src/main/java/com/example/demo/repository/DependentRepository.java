package com.example.demo.repository;

import com.example.demo.model.Dependent;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface DependentRepository extends JpaRepository<Dependent, Long> {

    List<Dependent> findByLastName(String name);

    <T extends Dependent> T save(T employee);

    List<Dependent> findByParentId(Long id);

}
