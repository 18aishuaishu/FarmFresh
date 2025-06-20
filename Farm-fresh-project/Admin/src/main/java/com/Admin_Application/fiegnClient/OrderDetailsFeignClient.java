package com.Admin_Application.fiegnClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.Admin_Application.entity.Item;
import com.Admin_Application.entity.Order;



@FeignClient("Order")
public interface OrderDetailsFeignClient {
	    @PostMapping("/ord/post")
	    public Order addOrder(@RequestBody Order newOrder);
	   
	    
	    @PutMapping("/ord/put/{orderid}") 
	    public ResponseEntity<Order> updateOrder(@PathVariable Long orderid, @RequestBody Order updatedOrder);
	
	    @GetMapping("/ord/ordera/{orderid}")
	    public Order getOrderById(@PathVariable Long orderid);
	}

		
