package com.example.ews.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ews.security.model.AdminUsers;

public interface AdminRepo extends JpaRepository<AdminUsers, Long> {

	AdminUsers findByAdminName(String username);
}
