package com.Order_Application.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.Order_Application.Dao.OrderInterface;
import com.Order_Application.repo.OrderRepository;



public class OrderService implements OrderInterface{
	
	  @Autowired 
	  private OrderRepository orderrepo;
	 
}
