package com.revature.raza.data;

import java.util.List;

import com.revature.raza.models.UserAccount;

import Utility.ConnectionObject;

public class AccountOperation implements Operations<UserAccount> {

	private ConnectionObject connObj = ConnectionObject.getConnectionUtil();

	@Override
	public UserAccount createAccount(UserAccount t) {
		// TODO Auto-generated method stub
		
		
		return null;
	}

	@Override
	public UserAccount findByUsername(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateRecord(UserAccount t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserAccount deleteRecord(UserAccount t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserAccount> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	
	

}
