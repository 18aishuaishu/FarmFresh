package com.Item_Application.controller;


import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Item_Application.entity.Item;
import com.Item_Application.repo.ItemRepository;
import com.Item_Application.service.ItemService;


@RestController
@RequestMapping("/items")
public class ItemController {
	
	@Autowired 
	private ItemRepository itemrepo;
	@Autowired
	ItemService is;
	
	//Get all items accessed by customer
	@GetMapping 
	public List<Item> getAllItems(){
		return itemrepo.findAll();
	}
	//Get by price accessed by customer
	@GetMapping("/low")
	public List<Item> getAllItemsbyprice(@RequestParam(name = "sort", required = false, defaultValue = "asc")String sortOrder)
	{
		Sort sort = sortOrder.equalsIgnoreCase("desc")?Sort.by("itemPrice").descending() : Sort.by("itemPrice").ascending();
		return itemrepo.findAll(sort);
		
	}
	
	//Get by id accessed by Customer
	//http://localhost:8084/items/itema?itemName=carrot
//	@GetMapping("/itema")
//	public List<Item> getItemsByItemName(@RequestParam String itemName) {
//        return is.getItemsByItemName(itemName);
//    }
	
	
	
	
	
		 @GetMapping("/itemp")
	    public String getItem(@RequestParam String itemName) {
	        return is.getItemByName(itemName);
	    }
	
	
	
	//Get by id accessed by admin
	@GetMapping("/item/{itemid}")
    public ResponseEntity<Item> getItemById(@PathVariable Long itemid) {
        return itemrepo.findById(itemid)
                .map(item -> ResponseEntity.ok(item))
                .orElse(ResponseEntity.notFound().build());
    }
	 // POST - Add a new item accessed by admin
    @PostMapping("/post")
    public Item addItem(@RequestBody Item newItem) {
        return itemrepo.save(newItem);
    }
 
    // PUT - Update an item by ID accessed by admin
	
    @PutMapping("/put/{itemid}") 
    public ResponseEntity<Item> updateItem(@PathVariable Long itemid, @RequestBody Item updatedItem) {
        Optional<Item> optionalItem = itemrepo.findById(itemid);
        
            Item item = optionalItem.get();
            item.setItemName(updatedItem.getItemName());
            item.setItemPrice(updatedItem.getItemPrice());
            item.setItemCategory(updatedItem.getItemCategory());
            item.setItemCount(updatedItem.getItemCount());
            final Item updatedItems = itemrepo.save(item);
            return ResponseEntity.ok(updatedItems);
        
       
	 }
    
     // DELETE - Delete an item by ID accessed by admin
	
    @DeleteMapping("/delete/{itemid}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long itemid) {
        Optional<Item> optionalItem = itemrepo.findById(itemid);
        if (optionalItem.isPresent()) {
            itemrepo.delete(optionalItem.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    
    
    
    @GetMapping("/i/{itemId}")
    public ResponseEntity<Item> getItem(@PathVariable Long itemId) {
        Item item = is.getItemById(itemId);
        if (item != null) {
            return ResponseEntity.ok(item);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
 
    @PostMapping("/reduce-count/{itemId}")
    public ResponseEntity<String> reduceItemCount(@PathVariable Long itemId, @RequestParam int count) {
        boolean updated = is.reduceItemCount(itemId, count);
        if (updated) {
            return ResponseEntity.ok("Item count reduced");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Item not available or insufficient stock");
        }
    }
    
    
    
}
