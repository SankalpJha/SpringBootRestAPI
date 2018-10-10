package com.example.ews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.ews.model.Employee;

@Component
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
