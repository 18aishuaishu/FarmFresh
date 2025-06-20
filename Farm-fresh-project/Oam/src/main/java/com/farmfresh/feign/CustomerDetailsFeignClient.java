package com.farmfresh.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.farmfresh.entity.Customer;


@FeignClient("Customer")
public interface CustomerDetailsFeignClient {

	@GetMapping("/cus/{custid}")
	public Customer getCustomerByCustomerId(@PathVariable Long custid);
	
	@GetMapping("/cus/cust")
	public List<Customer> getAllCustomers();
	
	@PostMapping("/cus/post")
    public Customer addCustomer(@RequestBody Customer newCustomer);
	
	@PutMapping("/cus/put/{custid}")
    public void updateCustomer(@PathVariable Long custid, @RequestBody Customer updatedCustomer);
}
