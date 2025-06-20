package com.Customer_Application;

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

import com.Customer_Application.FeignClient.ItemDetailsFeignClient;
import com.Customer_Application.FeignClient.OrderDetailsFeignClient;
import com.Customer_Application.entity.Customer;
import com.Customer_Application.entity.Order;
import com.Customer_Application.repo.CustomerRepository;
import com.Customer_Application.service.CustomerService;

public class CustomerServiceTest {
	 @Mock
	    private RestTemplate restTemplate;

	    @Mock
	    private CustomerRepository cusrepo;

	    @Mock
	    private OrderDetailsFeignClient oc;

	    @Mock
	    private ItemDetailsFeignClient Fc;

	    @InjectMocks
	    private CustomerService customerService;

	    @BeforeEach
	    public void setUp() {
	        MockitoAnnotations.openMocks(this);
	    }

	    @Test
	    public void testGetItemsFromItemService() {
	        // Arrange
	        List<Customer> mockResponse = new ArrayList<>();
	        mockResponse.add(new Customer());
	        mockResponse.add(new Customer());
	        when(restTemplate.getForObject("http://Item/items", ArrayList.class)).thenReturn((ArrayList) mockResponse);

	        // Act
	        List<Customer> result = customerService.getItemsFromItemService();

	        // Assert
	        assertNotNull(result);
	        assertEquals(2, result.size());
	        verify(restTemplate, times(1)).getForObject("http://Item/items", ArrayList.class);
	    }

	    @Test
	    public void testGetItemsPriceLowToHigh() {
	        // Arrange
	        List<Customer> mockResponse = new ArrayList<>();
	        mockResponse.add(new Customer());
	        mockResponse.add(new Customer());
	        when(restTemplate.getForObject("http://Item/items/low?sort=asc", ArrayList.class)).thenReturn((ArrayList) mockResponse);

	        // Act
	        List<Customer> result = customerService.getItemsPriceLowToHigh();

	        // Assert
	        assertNotNull(result);
	        assertEquals(2, result.size());
	        verify(restTemplate, times(1)).getForObject("http://Item/items/low?sort=asc", ArrayList.class);
	    }

	    @Test
	    public void testGetItemsPriceHighToLow() {
	        // Arrange
	        List<Customer> mockResponse = new ArrayList<>();
	        mockResponse.add(new Customer());
	        mockResponse.add(new Customer());
	        when(restTemplate.getForObject("http://Item/items/low?sort=desc", ArrayList.class)).thenReturn((ArrayList) mockResponse);

	        // Act
	        List<Customer> result = customerService.getItemsPriceHighToLow();

	        // Assert
	        assertNotNull(result);
	        assertEquals(2, result.size());
	        verify(restTemplate, times(1)).getForObject("http://Item/items/low?sort=desc", ArrayList.class);
	    }

	    @Test
	    public void testGetItemsSortedByPrice() {
	        // Arrange
	        List<Customer> mockResponse = new ArrayList<>();
	        mockResponse.add(new Customer());
	        mockResponse.add(new Customer());
	        when(restTemplate.getForObject("http://Item/items/low?sort=asc", ArrayList.class)).thenReturn((ArrayList) mockResponse);

	        // Act
	        List<Customer> result = customerService.getItemsSortedByPrice("asc");

	        // Assert
	        assertNotNull(result);
	        assertEquals(2, result.size());
	        verify(restTemplate, times(1)).getForObject("http://Item/items/low?sort=asc", ArrayList.class);
	    }

	    @Test
	    public void testGetOrdersFromOrderService() {
	        // Arrange
	        List<Customer> mockResponse = new ArrayList<>();
	        mockResponse.add(new Customer());
	        mockResponse.add(new Customer());
	        when(restTemplate.getForObject("http://ORDER/ord", ArrayList.class)).thenReturn((ArrayList) mockResponse);

	        // Act
	        List<Customer> result = customerService.getOrdersFromOrderService();

	        // Assert
	        assertNotNull(result);
	        assertEquals(2, result.size());
	        verify(restTemplate, times(1)).getForObject("http://ORDER/ord", ArrayList.class);
	    }

	    @Test
	    public void testGetOrderByCustomerId() {
	        // Arrange
	        Order mockOrder = new Order();
	        when(oc.getOrderByCustomerId(1L)).thenReturn(mockOrder);

	        // Act
	        Order result = customerService.getOrderByCustomerId(1L);

	        // Assert
	        assertNotNull(result);
	        verify(oc, times(1)).getOrderByCustomerId(1L);
	    }

	    @Test
	    public void testGetItemsByItemName() {
	        // Arrange
	        String mockResponse = "ItemName";
	        when(Fc.getItemsByItemName("ItemName")).thenReturn(mockResponse);

	        // Act
	        String result = customerService.getItemsByItemName("ItemName");

	        // Assert
	        assertNotNull(result);
	        assertEquals("ItemName", result);
	        verify(Fc, times(1)).getItemsByItemName("ItemName");
	    }
}
