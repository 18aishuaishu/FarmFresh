package com.Admin_Application.fiegnClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.Admin_Application.entity.Item;

@FeignClient("Item")
public interface ItemDetailsFeignClient {

	 @GetMapping("/items/item/{itemid}")
	    public Item getItemById(@PathVariable Long itemid);
	 @PostMapping("/items/post")
	  public Item addItem(@RequestBody Item newItem);
}
 
