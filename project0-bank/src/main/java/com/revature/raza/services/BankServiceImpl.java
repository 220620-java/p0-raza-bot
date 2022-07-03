package com.revature.raza.services;
import com.revature.raza.models.Account;

import com.revature.raza.data.BankCustomer;
import com.revature.raza.data.CustomerAccount;
import com.revature.raza.models.Customer;

public class BankServiceImpl implements BankService {
	private BankCustomer bc = new BankCustomer(); 
	private CustomerAccount ca = new CustomerAccount(); 
	boolean isCustomer = false; 

	@Override
	public Customer signUp(Customer customer) {
		// TODO Auto-generated method stub
		return bc.createCustomer(customer); 
		
	}

	@Override
	public Customer signIn(String username, String passwd) {
		// TODO Auto-generated method stub
		Customer customer = bc.findByUsername(username); 
		if (customer != null && passwd.equals(customer.getPasswd())) {
			isCustomer = true; 
			return customer; 
		}
		return null;
	}

	@Override
	public Account createAccount(Customer customer) {
		// TODO Auto-generated method stub
		Account ac = ca.create(customer); 
		
		
		return ac;
	}

	@Override
	public boolean depositeFund(int account_id, double amount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double withdrawFund(int account_id, double amount) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double viewBalance() {
		// TODO Auto-generated method stub
		return 0;
	}

}
