package com.revature.raza.services;

public interface BankService<T> extends Service<T> {

	public T createAccount(T customer); 
	
	public boolean depositeFund(int account_id, double amount); 
	
	public double withdrawFund(int account_id, double amount); 
	
	public double viewBalance();
}
