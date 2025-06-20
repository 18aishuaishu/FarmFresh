package com.Admin_Application.service;

import java.util.List;

import com.Admin_Application.entity.Admin;
import com.Admin_Application.entity.Item;
import com.Admin_Application.entity.Order;


public interface AdminInterface  {

	public Item getItemById(Long itemid);

	public Item addItem(Item newItem);

	public void updateItem(Long itemid, Item updatedItem);

	public void deleteItem(Long itemid);

	public List<Admin> getItemsFromItemService();

	public List<Admin> getCustomersFromCustomerService();
	
	public List<Admin> getOrdersFromOrderService();

	

	
	
	
}
