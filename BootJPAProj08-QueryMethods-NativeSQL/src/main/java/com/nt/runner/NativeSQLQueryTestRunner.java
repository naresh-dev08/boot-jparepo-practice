package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.repository.ICustomerRepository;

@Component
public class NativeSQLQueryTestRunner implements CommandLineRunner {

	@Autowired
	private ICustomerRepository custRepo;
	@Override
	
	
	public void run(String... args) throws Exception {
		
		/*int count = custRepo.insertCustomer("Raghu", "Vizg", 35679.78);
		if (count ==0) 
			System.out.println("Record not Inserted");
		else
		System.out.println(count + " Record is inserted");*/
		
		int count = custRepo.createTempTable();
		System.out.println("Table created "+count );

	}//Runner()

}//class
