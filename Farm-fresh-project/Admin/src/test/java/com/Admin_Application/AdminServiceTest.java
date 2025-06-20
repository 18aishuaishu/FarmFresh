package com.Admin_Application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import com.Admin_Application.entity.Admin;
import com.Admin_Application.entity.Item;
import com.Admin_Application.entity.Order;
import com.Admin_Application.fiegnClient.ItemDetailsFeignClient;
import com.Admin_Application.fiegnClient.OrderDetailsFeignClient;
import com.Admin_Application.service.AdminService;

public class AdminServiceTest {
	
	@Mock
    private RestTemplate restTemplate;

    @Mock
    private ItemDetailsFeignClient fc;

    @Mock
    private OrderDetailsFeignClient fe;

    @InjectMocks
    private AdminService adminService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetItemsFromItemService() {
        // Arrange
        List<Admin> mockResponse = new ArrayList<>();
        mockResponse.add(new Admin());
        mockResponse.add(new Admin());
        when(restTemplate.getForObject("http://Item/items", ArrayList.class)).thenReturn((ArrayList) mockResponse);

        // Act
        List<Admin> result = adminService.getItemsFromItemService();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        verify(restTemplate, times(1)).getForObject("http://Item/items", ArrayList.class);
    }

    @Test
    public void testGetItemById() {
        // Arrange
        Item mockItem = new Item();
        when(fc.getItemById(1L)).thenReturn(mockItem);

        // Act
        Item result = adminService.getItemById(1L);

        // Assert
        assertNotNull(result);
        verify(fc, times(1)).getItemById(1L);
    }

    @Test
    public void testAddItem() {
        // Arrange
        Item newItem = new Item();
        when(fc.addItem(newItem)).thenReturn(newItem);

        // Act
        Item result = adminService.addItem(newItem);

        // Assert
        assertNotNull(result);
        verify(fc, times(1)).addItem(newItem);
    }

    @Test
    public void testUpdateItem() {
        // Arrange
        Item updatedItem = new Item();

        // Act
        adminService.updateItem(1L, updatedItem);

        // Assert
        verify(restTemplate, times(1)).put("http://Item/items/put/1", updatedItem);
    }

    @Test
    public void testDeleteItem() {
        // Act
        adminService.deleteItem(1L);

        // Assert
        verify(restTemplate, times(1)).delete("http://Item/items/delete/1");
    }

    @Test
    public void testGetCustomersFromCustomerService() {
        // Arrange
        List<Admin> mockResponse = new ArrayList<>();
        mockResponse.add(new Admin());
        mockResponse.add(new Admin());
        when(restTemplate.getForObject("http://CUSTOMER/cus/cust", ArrayList.class)).thenReturn((ArrayList) mockResponse);

        // Act
        List<Admin> result = adminService.getCustomersFromCustomerService();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        verify(restTemplate, times(1)).getForObject("http://CUSTOMER/cus/cust", ArrayList.class);
    }

    @Test
    public void testGetOrdersFromOrderService() {
        // Arrange
        List<Admin> mockResponse = new ArrayList<>();
        mockResponse.add(new Admin());
        mockResponse.add(new Admin());
        when(restTemplate.getForObject("http://ORDER/ord", ArrayList.class)).thenReturn((ArrayList) mockResponse);

        // Act
        List<Admin> result = adminService.getOrdersFromOrderService();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        verify(restTemplate, times(1)).getForObject("http://ORDER/ord", ArrayList.class);
    }

    @Test
    public void testGetOrderById() {
        // Arrange
        Order mockOrder = new Order();
        when(fe.getOrderById(1L)).thenReturn(mockOrder);

        // Act
        Order result = adminService.getOrderById(1L);

        // Assert
        assertNotNull(result);
        verify(fe, times(1)).getOrderById(1L);
    }

    @Test
    public void testAddOrder() {
        // Arrange
        Order newOrder = new Order();
        when(fe.addOrder(newOrder)).thenReturn(newOrder);

        // Act
        Order result = adminService.addOrder(newOrder);

        // Assert
        assertNotNull(result);
        verify(fe, times(1)).addOrder(newOrder);
    }

    @Test
    public void testUpdateOrder() {
        // Arrange
        Order updatedOrder = new Order();

        // Act
        adminService.updateOrder(1L, updatedOrder);

        // Assert
        verify(restTemplate, times(1)).put("http://ORDER/ord/put/1", updatedOrder);
    }

    @Test
    public void testDeleteOrder() {
        // Act
        adminService.deleteOrder(1L);

        // Assert
        verify(restTemplate, times(1)).delete("http://ORDER/ord/delete/1");
    }
}
