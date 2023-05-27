package com.spring.service;

import com.spring.bo.CustomerBO;
import com.spring.dao.ICustomerDAO;
import com.spring.dto.CustomerDTO;

public class CustomerManagamentServiceImpl implements ICustomerManagamentService {

	private ICustomerDAO dao;
	public CustomerManagamentServiceImpl(ICustomerDAO dao) {
		this.dao = dao;
		System.out.println("CustomerManagamentServiceImpl :: 1 Param Constructor :: "+dao.getClass().getName());
	}
	@Override
	public String calculateSimpleInterest(CustomerDTO dto) throws Exception {

		float intrAmount = (dto.getPamt() * dto.getTime() * dto.getRate()) / 100.0f;

		CustomerBO customerBO = new CustomerBO();
		customerBO.setCustomerAddress(dto.getCustomerAddress());
		customerBO.setCustomerName(dto.getCustomerName());
		customerBO.setPamt(dto.getPamt());
		customerBO.setTime(dto.getTime());
		customerBO.setRate(dto.getRate());
		customerBO.setIntrAmount(intrAmount);
		int count = dao.save(customerBO);

		return count == 0 ? "customer registration failed"
				: "customer registration succesfull---->SimpleInterestAmount::" + intrAmount;
	}
}