package com.Item_Application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Item_Application.Dao.ItemInterface;
import com.Item_Application.entity.Item;
import com.Item_Application.repo.ItemRepository;
@Service
public class ItemService implements ItemInterface{
	
	@Autowired
	private ItemRepository itemrepo;

//	public List<Item> getItemsByItemName(String itemName) {
//
//		return itemrepo.findByItemName(itemName);
//	}

	
	
//	 public String getItemByName(String itemName) {
//	        return itemrepo.findByItemName(itemName)
//	                .map(item -> item.getItemCount() > 0 ? item.toString() : "Item not available")
//	                .orElse("Item not available");
//	    }
	
	
	
	
	 public String getItemByName(String itemName) {
	        Optional<Item> itemOpt = itemrepo.findByItemName(itemName);
	        if (itemOpt.isPresent()) {
	            Item item = itemOpt.get();
	            if (item.getItemCount() > 0) {
	                return "Item found: " + ", itemid: " + item.getItemid() +",itemName: " + item.getItemName() + ", itemCategory: " 
	            + item.getItemCategory() + ", itemCount: " + item.getItemCount() + ", itemPrice: " + item.getItemPrice(); 
	                
	            }
	        }
	        return "Item not available";
	    }
	
	
	
	public Item getItemById(Long itemId) {
        return itemrepo.findById(itemId).orElse(null);
    }
 
    public boolean reduceItemCount(Long itemId, int count) {
        Item item = getItemById(itemId);
        if (item != null && item.getItemCount() >= count) {
            item.setItemCount(item.getItemCount() - count);
            itemrepo.save(item);
            return true;
        }
        return false;
    }
	
}
