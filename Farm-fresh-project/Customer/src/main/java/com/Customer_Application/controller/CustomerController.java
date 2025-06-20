package com.Customer_Application.controller;

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

import com.Customer_Application.entity.Customer;
import com.Customer_Application.entity.Item;
import com.Customer_Application.entity.Order;
import com.Customer_Application.repo.CustomerRepository;
import com.Customer_Application.service.CustomerInterface;
import com.Customer_Application.service.CustomerService;



@RestController
@RequestMapping("/cus")
public class CustomerController {
	
	@Autowired
	private CustomerInterface cui;
	@Autowired
	private CustomerRepository custrepo;
	@Autowired
	private CustomerService cs;
	
	
	//Customer Service

	// POST - Add a new item accessed by Customer
    @PostMapping("/post")
    public Customer addCustomer(@RequestBody Customer newItem) {
        return custrepo.save(newItem);
    }
	
    
 // PUT - Update an item by ID accessed by Customer
	
    @PutMapping("/put/{custid}") 
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long custid, @RequestBody Customer updatedCustomer) {
        Optional<Customer> optionalCustomer = custrepo.findById(custid);
        
            Customer cus = optionalCustomer.get();
            cus.setCustid(updatedCustomer.getCustid());
            cus.setCusAccount(updatedCustomer.getCusAccount());
            cus.setCusAddress(updatedCustomer.getCusAddress());
            cus.setCusEmail(updatedCustomer.getCusEmail());
            cus.setCusName(updatedCustomer.getCusName());
            cus.setCusPhone(updatedCustomer.getCusPhone());
            final Customer updatedorders = custrepo.save(cus);
            return ResponseEntity.ok(updatedCustomer);
        
       
	 }
    
    
    // DELETE - Delete an item by ID accessed by Customer
    @DeleteMapping("/delete/{custid}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long custid) {
        Optional<Customer> optionalCustomer = custrepo.findById(custid);
        if (optionalCustomer.isPresent()) {
            custrepo.delete(optionalCustomer.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
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
	    
	    
	    //
	    @GetMapping("/cust")
		public List<Customer> getAllCustomers(){
			return custrepo.findAll();
		}
	    
	  //Get by id accessed by customer
		@GetMapping("/{custid}")
	    public ResponseEntity<Customer> getItemById(@PathVariable Long custid) {
	        return custrepo.findById(custid)
	                .map(customer -> ResponseEntity.ok(customer))
	                .orElse(ResponseEntity.notFound().build());
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
