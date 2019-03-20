package com.example.ews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.ews.model.Employee;
import com.example.ews.model.Roles;

@Component
public interface RolesRepo extends JpaRepository<Roles, Integer> {

}
