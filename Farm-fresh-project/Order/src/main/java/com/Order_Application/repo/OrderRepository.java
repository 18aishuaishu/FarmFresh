package com.Order_Application.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Order_Application.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
	

}