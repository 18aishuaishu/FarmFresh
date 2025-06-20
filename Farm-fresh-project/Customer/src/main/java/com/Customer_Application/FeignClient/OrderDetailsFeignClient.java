package com.Customer_Application.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Customer_Application.entity.Order;

@FeignClient("Order")
public interface OrderDetailsFeignClient {
	
	@GetMapping("/ord/orderb/{custtid}")
    public Order getOrderByCustomerId(@PathVariable Long custtid);
}
