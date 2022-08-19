package com.mle.emp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mle.emp.domain.Employee;
//Jpa parameters are <entity, data type of ID of that entity>
public interface empRepo extends JpaRepository<Employee, Integer>{
   Optional<Employee>findByEmail(String email);
}

