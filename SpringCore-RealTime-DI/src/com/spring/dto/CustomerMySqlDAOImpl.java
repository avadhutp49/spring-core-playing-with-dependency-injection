package com.spring.dto;


import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import com.spring.bo.CustomerBO;
import com.spring.dao.ICustomerDAO;

public class CustomerMySqlDAOImpl implements ICustomerDAO {
	
	private DataSource dataSource;
	private static String REALTIMEDI_CUSTOMER_INSERT_QUERY = "insert into customer(`cname`,`caddress`,`pamt`,`rate`,`time`,`intrAmt`)values(?,?,?,?,?,?)";
	int update=0;
	
	public CustomerMySqlDAOImpl(DataSource dataSource) {
		this.dataSource = dataSource;
		System.out.println("CustomerMySqlDAOImpl :: 1 param constructor :: " + dataSource.getClass().getName());
	}

	public int save(CustomerBO bo) throws Exception {
		
		try (Connection connection = dataSource.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(REALTIMEDI_CUSTOMER_INSERT_QUERY)) {
		
			pstmt.setString(1, bo.getCustomerName());
			pstmt.setString(2, bo.getCustomerAddress());
			pstmt.setFloat(3, bo.getPamt());
			pstmt.setFloat(4, bo.getRate());
			pstmt.setFloat(5, bo.getTime());
			pstmt.setFloat(6, bo.getIntrAmount());
			update = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}	
		return update;
	}
}