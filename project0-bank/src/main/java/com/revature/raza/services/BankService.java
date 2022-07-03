package com.revature.raza.services;

import com.revature.raza.models.Account;
import com.revature.raza.models.Customer;

public interface BankService extends Service {

	public Account createAccount(Customer customer); 
	
	public boolean depositeFund(int account_id, double amount); 
	
	public double withdrawFund(int account_id, double amount); 
	
	public double viewBalance();
}
