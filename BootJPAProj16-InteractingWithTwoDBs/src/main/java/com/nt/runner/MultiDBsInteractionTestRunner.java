package com.nt.runner;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.offers.Offers;
import com.nt.entity.prod.Product;
import com.nt.service.IMultiDBsInteractionServiceMgmt;

@Component
public class MultiDBsInteractionTestRunner implements CommandLineRunner {

	@Autowired
	private IMultiDBsInteractionServiceMgmt multiDBsService;

	@Override
	public void run(String... args) throws Exception {
		// save products
		/*List<Product> prodList = List.of(
				new Product("Table", 19000.0, 2, true, LocalDateTime.of(2025, 10, 12, 11, 33)),
				new Product("Chair", 18059.0, 3, true, LocalDateTime.of(2024, 11, 12, 11, 33)));
		multiDBsService.registerProducts(prodList);
		System.out.println("===========================================================");
		// save offers
		List<Offers> offersList = List.of(
				new Offers("MansoonOffer", 40.0f, LocalDateTime.now(), LocalDateTime.of(2023, 05, 25, 05, 45, 22)),
				new Offers("GreateIndiaSale", 40.0f, LocalDateTime.now(), LocalDateTime.of(2023, 05, 25, 05, 45, 22)));
		multiDBsService.registerOffers(offersList);*/
		
		//get all product details from Oracle DB
		multiDBsService.getAllProcuts().forEach(System.out::println);
		System.out.println("=================================");
		//get all offer details from MySQL DB
		multiDBsService.getAllOffers().forEach(System.out::println);
	}

}
