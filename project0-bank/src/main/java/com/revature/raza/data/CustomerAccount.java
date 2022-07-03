package com.revature.raza.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.raza.models.Customer;
import com.revature.raza.utility.ConnectionObject;
import com.revature.raza.utility.Generator;

public class CustomerAccount implements AccountAccessObject <Customer>{

	private ConnectionObject connObj = ConnectionObject.getConnectionUtil();
	

	@Override
	public Customer create(Customer account) {
		// TODO Auto-generated method stub
		int customer_id = account.getCustomer_id();
		
		try (Connection conn =  connObj.getConnection()) {
			
			conn.setAutoCommit(false);

			String sql = "insert into BankAccount "
					+ "(account_no, balance, customer_id) "
					+ "values (?, ?, ?) "; 
			
			PreparedStatement st = conn.prepareStatement(sql); 
			st.setString(1, Generator.randomGerenator());
			st.setDouble(2, 0.00);
			st.setInt(3, customer_id);
			
			int rowAdded = st.executeUpdate(sql); 
			if (rowAdded == 1) {
				conn.commit();
				
			} else {
				conn.rollback();
				account = null; 
			}	
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return account;
	}

	@Override
	public Customer delete(Customer account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer update(Customer account) {
		// TODO Auto-generated method stub
		return null;
	}

}
