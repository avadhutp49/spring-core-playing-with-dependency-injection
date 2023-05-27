package com.spring.controller;

import com.spring.dto.CustomerDTO;
import com.spring.service.ICustomerManagamentService;
import com.spring.vo.CustomerVO;

public class MainController {
	
	private ICustomerManagamentService service;
	
	
	
	public MainController(ICustomerManagamentService service) {
		this.service = service;
		System.out.println("MainController :: 1 Param Constructor :: "+service.getClass().getName());
	}



	public String processCustomer(CustomerVO vo) throws Exception{
		CustomerDTO customerDTO = new CustomerDTO();
		
		customerDTO.setCustomerAddress(vo.getCustomerAddress());
		customerDTO.setCustomerName(vo.getCustomerName());
		customerDTO.setPamt(Float.parseFloat(vo.getPamt()));
		customerDTO.setRate(Float.parseFloat(vo.getRate()));
		customerDTO.setTime(Float.parseFloat(vo.getTime()));
		
		return service.calculateSimpleInterest(customerDTO);
	}
}