package com.farmfresh.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farmfresh.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
	

}