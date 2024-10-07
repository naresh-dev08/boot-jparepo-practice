package com.nt.runner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.repository.ICustomerRepository;

@Component
public class FindMethodsTestRuunner implements CommandLineRunner {

	@Autowired
	private ICustomerRepository custRepo;
	
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println(custRepo.getClass()+""+Arrays.toString(custRepo.getClass().getInterfaces()));
        custRepo.findByBillamtBetween(55000.0f, 69000.0f).forEach(view->{
    	System.out.println(view.getClass()+"     "+Arrays.toString(view.getClass().getInterfaces()));
    	System.out.println(view.getCid()+"     "+view.getCname());
    });
	}

}
