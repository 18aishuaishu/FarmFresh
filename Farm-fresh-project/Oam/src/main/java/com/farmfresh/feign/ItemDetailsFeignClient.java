package com.farmfresh.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.farmfresh.entity.Item;

@FeignClient("Item")
public interface ItemDetailsFeignClient {

	 @GetMapping("/items/item/{itemid}")
	    public Item getItemById(@PathVariable Long itemid);
	 @PostMapping("/items/post")
	  public Item addItem(@RequestBody Item newItem);

	 @GetMapping("/items/itemp")
		public String getItemsByItemName(@RequestParam String itemName);
}
 
