package com.revature.raza.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.raza.models.Account;
import com.revature.raza.models.Customer;
import com.revature.raza.utility.ConnectionObject;
import com.revature.raza.utility.Generator;

public class CustomerAccount implements AccountAccessObject<Account>{

	private ConnectionObject connObj = ConnectionObject.getConnectionUtil();
	

	@Override
	public Account create(Customer account) {
		// TODO Auto-generated method stub
		int customer_id = account.getCustomer_id();
		String account_no = Generator.randomGerenator(); 
		double defaultVal = 0.00; 
		Account userAccount = null; 
		
		try (Connection conn =  connObj.getConnection()) {
			
			conn.setAutoCommit(false);

			String sql = "insert into BankAccount "
					+ "(account_no, balance, customer_id) "
					+ "values (?, ?, ?)"; 
			
			PreparedStatement st = conn.prepareStatement(sql); 
			st.setString(1, account_no);
			st.setDouble(2, 0.00);
			st.setInt(3, customer_id);
			
			int rowAdded = st.executeUpdate(); 
			if (rowAdded == 1) {
				userAccount = new Account(account_no, "Checking", defaultVal); 
				conn.commit();
				
			} else {
				conn.rollback();
				userAccount = null; 
			}	
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userAccount;
	}

	@Override
	public Account delete(Customer account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account update(Customer account) {
		// TODO Auto-generated method stub
		return null;
	}

}
