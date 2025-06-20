package com.farmfresh.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.farmfresh.entity.Customer;
import com.farmfresh.entity.Order;
import com.farmfresh.feign.CustomerDetailsFeignClient;
import com.farmfresh.feign.ItemDetailsFeignClient;
import com.farmfresh.feign.OrderDetailsFeignClient;
import com.farmfresh.repository.CustomerRepository;
import com.farmfresh.serviceimpl.CustomerInterface;
@Service
public class CustomerService implements CustomerInterface{
	
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	private CustomerRepository cusrepo;
	@Autowired
	OrderDetailsFeignClient oc;
	@Autowired
	ItemDetailsFeignClient Fc;
	@Autowired
	CustomerDetailsFeignClient cf;
	
	public List<Customer>getItemsFromItemService(){
		return restTemplate.getForObject("http://Item/items", ArrayList.class);
		}
	
		public List<Customer> getItemsPriceLowToHigh() {
			return restTemplate.getForObject("http://Item/items/low?sort=asc", ArrayList.class);
			// String url = "http://localhost:8084/items/low?sort=asc";

		}
		
		public Customer getCustomerByCustomerId(@PathVariable Long custid) {
			return cf.getCustomerByCustomerId(custid);
			}
		
		public Customer addCustomer(Customer newCustomer) {
			return cf.addCustomer(newCustomer);
	     
	    }
		
		public List<Customer> getAllCustomers()
		{
		return cf.getAllCustomers();
		}
		
		// PUT - Update an item by ID in Item Service
	    public  void updateCustomer(Long custid, Customer updatedCustomer) {
	    	restTemplate.put("http://Customer/cus/put/"+custid, updatedCustomer);
	    }
		
		
		// Function to get items sorted by price high to low (desc)
		public List<Customer> getItemsPriceHighToLow() {
			return restTemplate.getForObject("http://Item/items/low?sort=desc", ArrayList.class);
		}

		// DELETE - Delete an item by ID in Item Service
	    public void deleteCustomer(Long custid) {
	        restTemplate.delete("http://Customer/cus/delete/"+custid);
	    }
		
		public List<Customer> getItemsSortedByPrice(String sortOrder) {
			return restTemplate.getForObject("http://Item/items/low?sort=" + sortOrder, ArrayList.class);
		}
	
		
		
		public List<Customer> getOrdersFromOrderService() {
			return restTemplate.getForObject("http://ORDER/ord", ArrayList.class);
			    }

		// GET - View a single item by ID in Order Service	
	    public Order getOrderByCustomerId(Long custtid) {
	        return oc.getOrderByCustomerId(custtid);
	    	//return restTemplate.getForObject("http://ORDER/ord/orderb/"+custid);
	    	
	    }

		public String getItemsByItemName(String itemName) {
			
			//return restTemplate.getForObject("//http://localhost:8084/items/itema", ArrayList.class);
			return Fc.getItemsByItemName(itemName);
		}
	}
