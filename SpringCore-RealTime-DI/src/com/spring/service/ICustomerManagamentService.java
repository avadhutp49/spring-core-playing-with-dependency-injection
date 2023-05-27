package com.spring.service;

import com.spring.dto.CustomerDTO;

public interface ICustomerManagamentService {
	public String calculateSimpleInterest(CustomerDTO dto) throws Exception;
}
