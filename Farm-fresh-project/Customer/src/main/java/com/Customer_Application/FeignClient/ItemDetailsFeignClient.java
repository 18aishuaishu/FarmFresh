package com.Customer_Application.FeignClient;

import java.util.List;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@FeignClient("Item")
public interface ItemDetailsFeignClient {

	 @GetMapping("/items/itemp")
		public String getItemsByItemName(@RequestParam String itemName);
}
 
