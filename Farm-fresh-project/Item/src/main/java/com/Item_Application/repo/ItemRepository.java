package com.Item_Application.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.util.Streamable;

import com.Item_Application.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{
		List<Item> findAll(Sort sort);

	   // List<Item> findByItemName(String itemName);
	    Optional<Item> findByItemName(String itemName);
	}

