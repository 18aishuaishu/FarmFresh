package com.Customer_Application.service;

import java.util.List;
import java.util.Optional;

import com.Customer_Application.entity.Customer;

public interface CustomerInterface {
	public List<Customer>getItemsFromItemService();
	public List<Customer> getItemsSortedByPrice(String sortOrder);
	public List<Customer> getItemsPriceLowToHigh();
	public List<Customer> getItemsPriceHighToLow() ;
	public List<Customer> getOrdersFromOrderService();
	//public List<Customer> findById(Long custId);
	
}