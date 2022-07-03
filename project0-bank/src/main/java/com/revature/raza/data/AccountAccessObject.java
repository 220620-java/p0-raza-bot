package com.revature.raza.data;

import com.revature.raza.models.Customer;

public interface AccountAccessObject<T> {
	
	public T create(Customer account); 
	public T delete(Customer account); 
	public T update(Customer account);

}
