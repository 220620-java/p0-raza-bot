package com.revature.raza.services;

import com.revature.raza.data.BankCustomer;

public interface Service<T> {
	
	
	public T signUp(T customer);
	
	public T signIn(String username, String passwd); 
	
	

}
