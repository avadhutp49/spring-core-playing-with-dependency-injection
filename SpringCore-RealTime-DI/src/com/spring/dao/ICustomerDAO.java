package com.spring.dao;

import com.spring.bo.CustomerBO;

public interface ICustomerDAO {
	public int save(CustomerBO bo) throws Exception;
}
