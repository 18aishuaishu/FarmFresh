package com.Order_Application.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.Order_Application.entity.Order;
import com.Order_Application.repo.OrderRepository;

@RestController
@RequestMapping("/ord")
public class OrderController {
	
	
	 @Autowired 
	 private OrderRepository orderrepo;
	 // Get All orders accessed by both admin and customer.
	@GetMapping
	public List<Order>getAllOrders(){
		return orderrepo.findAll();
	}
	
	
	//Get by id accessed by customer
			@GetMapping("/orderb/{custtid}")
		    public ResponseEntity<Order> getOrderByCustomerId(@PathVariable Long custtid) {
		        return orderrepo.findById(custtid)
		                .map(order -> ResponseEntity.ok(order))
		                .orElse(ResponseEntity.notFound().build());
		    }
			
	
	//Get by id accessed by admin
		@GetMapping("/ordera/{orderid}")
	    public ResponseEntity<Order> getOrderById(@PathVariable Long orderid) {
	        return orderrepo.findById(orderid)
	                .map(order -> ResponseEntity.ok(order))
	                .orElse(ResponseEntity.notFound().build());
	    }
		
		 // POST - Add a new item accessed by admin
	    @PostMapping("/post")
	    public Order addItem(@RequestBody Order newItem) {
	        return orderrepo.save(newItem);
	    }
	 
	    // PUT - Update an item by ID accessed by admin
		
	    @PutMapping("/put/{orderid}") 
	    public ResponseEntity<Order> updateOrder(@PathVariable Long orderid, @RequestBody Order updatedOrder) {
	        Optional<Order> optionalOrder = orderrepo.findById(orderid);
	        
	            Order orders = optionalOrder.get();
	            orders.setOrderId(updatedOrder.getOrderId());
	            orders.setOrderDate(updatedOrder.getOrderDate());
	            orders.setOrderstatus(updatedOrder.getOrderstatus());	            orders.setOrderType(updatedOrder.getOrderType());
	            final Order updatedorders = orderrepo.save(orders);
	            return ResponseEntity.ok(updatedorders);
	        
	       
		 }
	    
	     // DELETE - Delete an item by ID accessed by admin
		
	    @DeleteMapping("/delete/{orderid}")
	    public ResponseEntity<Void> deleteItem(@PathVariable Long orderid) {
	        Optional<Order> optionalItem = orderrepo.findById(orderid);
	        if (optionalItem.isPresent()) {
	            orderrepo.delete(optionalItem.get());
	            return ResponseEntity.noContent().build();
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

}
