package com.farmfresh.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farmfresh.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	//Optional<Customer> findById(Long custid);

	//Optional<Customer> findByCustid(Long custId);

	//Optional<Customer> findById(Long id);

	
	

}