package com.farmfresh.serviceimpl;



import java.util.List;

import com.farmfresh.entity.Admin;
import com.farmfresh.entity.Item;


public interface AdminInterface  {

	public Item getItemById(Long itemid);

	public Item addItem(Item newItem);

	public void updateItem(Long itemid, Item updatedItem);

	public void deleteItem(Long itemid);

	public List<Admin> getItemsFromItemService();

	public List<Admin> getCustomersFromCustomerService();
	
	public List<Admin> getOrdersFromOrderService();

	

	
	
	
}
