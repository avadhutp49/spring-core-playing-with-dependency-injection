package com.spring.test;

import java.util.Scanner;


import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.controller.MainController;
import com.spring.vo.CustomerVO;

public class MainTest {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the customerName:: ");
		String customerName = scanner.next();

		System.out.print("Enter the customerAddress:: ");
		String customerAddress = scanner.next();

		System.out.print("Enter the principalAmount:: ");
		String pamt = scanner.next();

		System.out.print("Enter the RateOfInterest:: ");
		String rate = scanner.next();

		System.out.print("Enter the TimePeriod:: ");
		String time = scanner.next();

		CustomerVO customerVO = new CustomerVO();
		customerVO.setCustomerName(customerName);
		customerVO.setCustomerAddress(customerAddress);
		customerVO.setPamt(pamt);
		customerVO.setRate(rate);
		customerVO.setTime(time);
				
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("com/spring/cfg/applicationContext.xml");
						
		System.out.println("===== Container Started =====");

		MainController controller = factory.getBean("costomerController", MainController.class);
		try {
			String result = controller.processCustomer(customerVO);
			System.out.println(result);
		} catch (Exception e) {
			System.out.println("Internal problem.. Try again....." + e.getMessage());
		}
		
		System.out.println("===== Container Stopped =====");
	}
}
