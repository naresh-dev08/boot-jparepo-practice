package com.nt.runner;

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
		
		/*custRepo.findByCaddIn(List.of("Hyd", "Pune"), IResultView1.class).forEach(view1 -> {
			System.out.println(view1.getCid()+"   "+view1.getCname());
		});
		
		System.out.println("------------------------------------------------------");
		custRepo.findByCaddIn(List.of("Hyd", "Pune"), IResultView2.class).forEach(view2 -> {
			System.out.println(view2.getCid()+"   "+view2.getCname()+"   "+view2.getBillamt());
		});
		
		System.out.println("------------------------------------------------------");
		custRepo.findByCaddIn(List.of("Hyd", "Pune"), IResultView3.class).forEach(view3 -> {
			System.out.println(view3.getCadd()+"   "+view3.getCname()+"   "+view3.getBillamt());
		});*/
		
		System.out.println("------------------------------------------------------");
		System.out.println(custRepo.findByCid(26));
	}//method

}//class
