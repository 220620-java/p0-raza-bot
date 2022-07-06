package com.revature.raza.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.raza.models.Customer;

@ExtendWith(MockitoExtension.class)
class TestBankCustomer {

	@InjectMocks 
	private BankCustomer bankCustomer = new BankCustomer(); 
	
	@Mock
	private Customer customer;
	
	
	@Test
	public void testCreateCustomer() {
		Customer customer = new Customer(3, "Mubasher", new Date(2021-01-01),
				"m@gmail.com", "19021100110", "33222"); 
		assertEquals(customer, bankCustomer.createCustomer(customer)); 
	}
	
	@Test
	public void testFindByUsername() {
		String username = "Saba"; 
		Customer customer = bankCustomer.findByUsername(username); 
		assertNotNull(customer); 
	}
	
	@Test
	public void testUpdateEmail() {
		int customer_id = 1; 
		String email = "busy123@gmail.com"; 
		boolean isUpdated = bankCustomer.updateEmail(customer_id, email); 
		assertTrue(isUpdated); 
		
	}
	
	@Test
	public void testDeleteCustomer()
	{
		int mockId = 4; 
		Mockito.when(customer.getCustomer_id()).thenReturn(mockId); 
		boolean isDeleted = bankCustomer.deleteCustomer(customer); 
		assertTrue(isDeleted); 
	}
}
