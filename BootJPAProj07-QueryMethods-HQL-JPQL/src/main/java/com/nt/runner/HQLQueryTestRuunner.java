package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.repository.ICustomerRepository;

//@Component
public class HQLQueryTestRuunner implements CommandLineRunner {

	@Autowired
	private ICustomerRepository custRepo;
	
	
	@Override
	public void run(String... args) throws Exception {
		
  //  custRepo.getAllCustomers().forEach(System.out::println);
		
		//custRepo.getCustomersByBillAmountRange(55000.0f, 70000.0f).forEach(System.out::println);
		
		//custRepo.getCustomersByBillAmountRange("where",55000.0f, 70000.0f).forEach(System.out::println);
	    //custRepo.getCustomersByBillAmountRange("Cutomer",55000.0f, 70000.0f).forEach(System.out::println);
		
		/*List<Object[]> list = custRepo.getCustomersData("Raja", "Rahul");
		list.forEach(row->{
		   for(Object val:row) {
			   System.out.print(val+" ");
		   }
		   System.out.println();
		});*/
		
		
		/*List<String> list1 = custRepo.findCustomersAddrsByNameChars("R%");
		list1.forEach(addrs -> {
		 System.out.println(addrs);
		});*/
		
		
		/*Customer cust = custRepo.findCustomerDataByAddrs("WDK");
		  System.out.println(cust);*/
		
		/*Object object = custRepo. findCustomerDetailsByAddrs("WDK");
		Object data[] = (Object[]) object;
		  System.out.println("Customer details ::: "+Arrays.toString(data));*/
		
		//System.out.println("Customer Name :: "+custRepo.fetchCustomerNameByAddrs("WDK"));
	
	    // System.out.println("Customers Count :: "+custRepo.fetchAllCustomersCount());
		
		Object aggregateData[] = (Object[])custRepo.fetchCustomersAggregateData();
		System.out.println("Count ::"+aggregateData[0]);
		System.out.println("Max BillAmount ::"+aggregateData[1]);
		System.out.println("Min BillAmount ::"+aggregateData[2]);
		System.out.println("Avg BillAmount ::"+aggregateData[3]);
		System.out.println("Sum of BillAmount ::"+aggregateData[4]);
	}

}
