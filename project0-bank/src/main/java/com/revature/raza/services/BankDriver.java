package com.revature.raza.services;

import com.revature.raza.models.Account;
import com.revature.raza.models.Customer;

public class BankDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Customer result = null; 
//		Customer user1 = new Customer(1, "Huda", 
//				new Date(2020-01-01),
//				"Huda@gmail.com", "10101010101", "123456789"); 
		
		BankServiceImpl bs = new BankServiceImpl(); 
//		Customer result = bs.signUp(user1); 
//		if (result != null) {
//			System.out.println("Signed up successfully");
//		}
		result = bs.signIn("Huda", "123456789"); 
		if (result != null) {
			System.out.println("Signed in successfully");
		}
		
		Account ac = bs.createAccount(result); 
		if (ac != null) {
			System.out.println("Account created successfully");
		}
	}

}
