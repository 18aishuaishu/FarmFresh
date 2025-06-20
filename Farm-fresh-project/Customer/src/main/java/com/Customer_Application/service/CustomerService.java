package com.Customer_Application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Customer_Application.FeignClient.ItemDetailsFeignClient;
import com.Customer_Application.FeignClient.OrderDetailsFeignClient;
import com.Customer_Application.entity.Customer;
import com.Customer_Application.entity.Item;
import com.Customer_Application.entity.Order;
import com.Customer_Application.repo.CustomerRepository;
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
	
	public List<Customer>getItemsFromItemService(){
		return restTemplate.getForObject("http://Item/items", ArrayList.class);
		}
	
		public List<Customer> getItemsPriceLowToHigh() {
			return restTemplate.getForObject("http://Item/items/low?sort=asc", ArrayList.class);
			// String url = "http://localhost:8084/items/low?sort=asc";

		}

		// Function to get items sorted by price high to low (desc)
		public List<Customer> getItemsPriceHighToLow() {
			return restTemplate.getForObject("http://Item/items/low?sort=desc", ArrayList.class);
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
