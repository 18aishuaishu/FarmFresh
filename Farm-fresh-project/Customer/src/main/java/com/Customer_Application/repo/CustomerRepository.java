package com.Customer_Application.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Customer_Application.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	//Optional<Customer> findById(Long custid);

	//Optional<Customer> findByCustid(Long custId);

	//Optional<Customer> findById(Long id);

	
	

}