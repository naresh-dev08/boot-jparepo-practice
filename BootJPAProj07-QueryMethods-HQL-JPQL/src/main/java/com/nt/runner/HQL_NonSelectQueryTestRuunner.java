package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.repository.ICustomerRepository;

@Component
public class HQL_NonSelectQueryTestRuunner implements CommandLineRunner {

	@Autowired
	private ICustomerRepository custRepo;

	@Override
	public void run(String... args) throws Exception {
		
		//invike the b.method
		/*int count = custRepo.updateCustomerBillAmountByAddtrsses(10.0, "Pune", "WDK");
		System.out.println(count);*/
		
		int count = custRepo.deleteCustomerByBillAmountRange(100000.0, 1000000.0);
		System.out.println("No of records that are deleted are ::"+count);
	}
}
