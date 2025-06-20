package com.Admin_Application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Admin_Application.entity.Admin;
import com.Admin_Application.entity.Item;
import com.Admin_Application.entity.Order;
import com.Admin_Application.fiegnClient.ItemDetailsFeignClient;
import com.Admin_Application.fiegnClient.OrderDetailsFeignClient;
import com.Admin_Application.repo.AdminRepository;



@Service
public class AdminService implements AdminInterface{
	
	@Autowired
    private RestTemplate restTemplate;
	@Autowired
	ItemDetailsFeignClient Fc;
	
	@Autowired
	OrderDetailsFeignClient fe;
	
	@Autowired
	private AdminRepository adminrepo;
	
	// GET - View a All item by ID in Item Service
	public List<Admin>getItemsFromItemService(){
		return restTemplate.getForObject("http://Item/items", ArrayList.class);
		}
	
	
	  // GET - View a single item by ID in Item Service
    public Item getItemById(Long itemid) {
        return Fc.getItemById(itemid);
    }
  
 
    // POST - Add a new item in Item Service
		public Item addItem(Item newItem) {
			return Fc.addItem(newItem);
	     
	    }
 
    // PUT - Update an item by ID in Item Service
    public  void updateItem(Long itemid, Item updatedItem) {
    	restTemplate.put("http://Item/items/put/"+itemid, updatedItem);
    }
 
    // DELETE - Delete an item by ID in Item Service
    public void deleteItem(Long itemid) {
        restTemplate.delete("http://Item/items/delete/"+itemid);
    }
    
    public List<Admin>getCustomersFromCustomerService(){
		return restTemplate.getForObject("http://CUSTOMER/cus/cust", ArrayList.class);
		}

    
// // GET - View a single Customer by ID in Item Service
//    public Customer getCustomerById(Long custid) {
//        return Fc.getcustById(custid);
//    }
    
    public List<Admin>getOrdersFromOrderService(){
		return restTemplate.getForObject("http://ORDER/ord", ArrayList.class);
		}
    
    // GET - View a single item by ID in Item Service	
    public Order getOrderById(Long orderid) {
        return fe.getOrderById(orderid);
    }
    	// POST - Add a new item in Item Service
 		public Order addOrder(Order newOrder) {
 			return fe.addOrder(newOrder);
 	     
 	    }
 		
		//public ResponseEntity<Order> updateOrder(Long orderid, Order updatedOrder) {
 		public  void updateOrder(Long orderid, Order updatedOrder) {
			 restTemplate.put("http://ORDER/ord/put/" + orderid, updatedOrder);
		}
 		
 		 // DELETE - Delete an item by ID in Item Service
 	    public void deleteOrder(Long orderid) {
 	     restTemplate.delete("http://ORDER/ord/delete/"+orderid);

 	    }
}
	