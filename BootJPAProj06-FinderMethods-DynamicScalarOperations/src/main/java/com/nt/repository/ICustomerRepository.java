package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Customer;
import com.nt.rview.IResultView;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
	
	//Scalar Operations
	public <T extends IResultView > List<T> findByCaddIn(List<String> addresses, Class<T> clazz);
	
	public Customer findByCid(int cno);
}
