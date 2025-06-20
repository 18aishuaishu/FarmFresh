package com.Admin_Application.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Admin_Application.entity.Admin;
import com.Admin_Application.entity.Item;
import com.Admin_Application.entity.Order;
import com.Admin_Application.service.AdminInterface;
import com.Admin_Application.service.AdminService;


@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminInterface ai;
	@Autowired
	private AdminService as;
	
	//Get - View all the items from Item service
	@GetMapping("/items")
	public List<Admin> getItems()
	{
		return ai.getItemsFromItemService();
	}
	
	// GET - View a single item by ID
    @GetMapping("/item/{itemid}")
    public Item getItemById(@PathVariable Long itemid) {
        return ai.getItemById(itemid);
    }
 
    // POST - Add a new item
    @PostMapping("/post")
    public Item addItem(@RequestBody Item newItem) {
        return ai.addItem(newItem);
    }
 
    // PUT - Update an item by ID
    @PutMapping("/put/{itemid}")
    public void updateItem(@PathVariable Long itemid, @RequestBody Item updatedItem) {
       ai.updateItem(itemid, updatedItem);
    }
 
    // DELETE - Delete an item by ID
    @DeleteMapping("/delete/{itemid}")
    public void deleteItem(@PathVariable Long itemid) {
        ai.deleteItem(itemid);
    }
    
    //Get- View all the customer details
    @GetMapping("/cus")
	public List<Admin> getCustomers()
	{
		return ai.getCustomersFromCustomerService();
	}
    
 // GET - View a single customer by ID
    //  @GetMapping("/cus/{custid}")
      //public Customer getCustomerById(@PathVariable Long custid) {
      //return ai.getCustomerById(custid);
    //}
    
    //Get - View all orders from order service
    @GetMapping("/order")
	public List<Admin> getorders()
	{
		return ai.getOrdersFromOrderService();
	}
    
    
 // GET - View a single item by ID
    @GetMapping("/ordera/{orderid}")
    public Order getOrderById(@PathVariable Long orderid) {
        return as.getOrderById(orderid);
    }
    
	
 // POST - Add a new order
    @PostMapping("/order/post")
    public Order addOrder(@RequestBody Order newOrder) {
        return as.addOrder(newOrder);
    }
    
   //Put - Update details in order service  based on id 
    @PutMapping("/ord/put/{orderid}")
    public void updateOrder(@PathVariable Long orderid, @RequestBody Order updatedOrder) {
       as.updateOrder(orderid, updatedOrder);
    }
    
    // DELETE - Delete an order by ID
    @DeleteMapping("/ord/delete/{orderid}")
    public void deleteOrder(@PathVariable Long orderid) {
        as.deleteOrder(orderid);
    }
    
 
}
