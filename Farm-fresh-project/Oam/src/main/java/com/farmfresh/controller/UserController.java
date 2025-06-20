
package com.farmfresh.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.farmfresh.entity.Customer;
import com.farmfresh.entity.Order;
import com.farmfresh.repository.CustomerRepository;
import com.farmfresh.service.CustomerService;
import com.farmfresh.serviceimpl.CustomerInterface;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private CustomerInterface cui;
	@Autowired
	private CustomerRepository custrepo;
	@Autowired
	private CustomerService cs;
	
	
	//Customer Service

	 //
    @GetMapping("/cust")
	public List<Customer> getAllCustomers(){
		return cs.getAllCustomers();
	}
	
	//Get by id accessed by customer
	@GetMapping("/cust/{custid}")
	public Customer getCustomerByCustomerId(@PathVariable Long custid) {
		return cs.getCustomerByCustomerId(custid);
	}
	
	@PostMapping("/post")
    public Customer addCustomer(@RequestBody Customer newCustomer) {
        return cs.addCustomer(newCustomer);
    }
	
    
 // PUT - Update an item by ID accessed by Customer

    @PutMapping("/put/{custid}")
    public void updateCustomer(@PathVariable Long custid, @RequestBody Customer updatedCustomer) {
       cs.updateCustomer(custid, updatedCustomer);
    }
    
    // DELETE - Delete an item by ID accessed by Customer

    @DeleteMapping("/delete/{custid}")
    public void deleteCustomer(@PathVariable Long custid) {
        cs.deleteCustomer(custid);
    }
    
	//Item Service
	@GetMapping("/items")
	public List<Customer> getItems()
	{
		return cui.getItemsFromItemService();
	}
	

	 @GetMapping("/items/low-to-high")
	    public List<Customer> getItemsLowToHigh() {
	        return cui.getItemsPriceLowToHigh();
	    }
	 
	    // Fetch items sorted by price high to low
	    @GetMapping("/items/high-to-low")
	    public List<Customer> getItemsHighToLow() {
	        return cui.getItemsPriceHighToLow();
	    }
	    
	    
	    //Get - to view item details based on item name accessed by customer
	    @GetMapping("/itemp")
		public String getItemsByItemName(@RequestParam String itemName) {
	        return cs.getItemsByItemName(itemName);
	    }
  
	  
	    //Order Service
	    @GetMapping("/orders")
	    public List<Customer> getOrders() {
	        return cui.getOrdersFromOrderService();
	    }
	    
	 // GET - View a single order by customer ID
	    @GetMapping("/orderb/{custtid}")
	    public Order getOrderByCustomerId(@PathVariable Long custtid) {
	        return cs.getOrderByCustomerId(custtid);
	    }
	    
	    
}
