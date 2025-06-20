package com.farmfresh.serviceimpl;



import java.util.List;

import com.farmfresh.entity.Customer;

public interface CustomerInterface {
	public List<Customer>getItemsFromItemService();
	public List<Customer> getItemsSortedByPrice(String sortOrder);
	public List<Customer> getItemsPriceLowToHigh();
	public List<Customer> getItemsPriceHighToLow() ;
	public List<Customer> getOrdersFromOrderService();
	//public List<Customer> findById(Long custId);
	
}