package com.revature.raza.data;

public interface AccountAccessObject<T> {
	
	public T create(T account); 
	public T delete(T account); 
	public T update(T account);

}
