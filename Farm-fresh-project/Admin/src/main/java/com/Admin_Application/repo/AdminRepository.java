package com.Admin_Application.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Admin_Application.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
	

}