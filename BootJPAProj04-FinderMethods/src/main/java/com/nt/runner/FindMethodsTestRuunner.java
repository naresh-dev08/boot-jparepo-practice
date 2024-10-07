package com.nt.runner;

import java.util.List;

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
		
     //custRepo.findByCnameEquals("Raja").forEach(System.out::println);
	 //custRepo.findByCnameIs("Raja").forEach(System.out::println);
	 //custRepo.readByCname("Raja").forEach(System.out::println);
	//custRepo.getByCname("Raja").forEach(System.out::println);
	//custRepo.showByCname("Raja").forEach(System.out::println); //runtime error
		
	//custRepo.findByBillamtBetween(55000.0f, 69000.0f).forEach(System.out::println);	
		
		//custRepo.findByCnameStartsWith("R").forEach(System.out::println);
        //custRepo. findByCnameEndsWith("a").forEach(System.out::println);
		 // custRepo.findByCnameContaining("i").forEach(System.out::println);
		  //custRepo.findByCnameContainingIgnoreCase("A").forEach(System.out::println);
		  //custRepo.findByCnameLikeIgnoreCase("%i").forEach(System.out::println);
		  //custRepo.findByCnameLikeIgnoreCase("%i%").forEach(System.out::println);
		 //custRepo.findByCnameLikeIgnoreCase("i%").forEach(System.out::println);
		 //custRepo.findByCnameLikeIgnoreCase("___").forEach(System.out::println);
		
		//custRepo.findByBillamtGreaterThanEqualAndBillamtLessThanEqual(25000.0f, 69000.0f).forEach(System.out::println);
		custRepo.findByCaddInIgnoreCaseOrCnameContainingIgnoreCase(List.of("Hyd", "Pune"),"r").forEach(System.out::println);
	}

}
