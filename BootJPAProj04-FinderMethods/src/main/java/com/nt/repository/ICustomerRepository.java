package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
	
	public List<Customer> findByCnameEquals(String name);
	public List<Customer> findByCnameIs(String name);
	public List<Customer> readByCname(String name);
	public List<Customer> getByCname(String name);
	
	//public List<Customer> showByCname(String name); //Runtime Error
	
	public List<Customer> findByBillamtBetween(float startAmount, float endAmount);
	
	public List<Customer> findByCnameStartsWith(String initialChars);
	public List<Customer> findByCnameEndsWith(String lastChars);
	public List<Customer> findByCnameContaining(String chars);
	public List<Customer> findByCnameContainingIgnoreCase(String chars);
	public List<Customer> findByCnameLikeIgnoreCase(String chars);
	
	public List<Customer> findByBillamtGreaterThanEqualAndBillamtLessThanEqual(float startAmout, float endAmount);
	public List<Customer> findByCaddInIgnoreCaseOrCnameContainingIgnoreCase(List<String> address, String nameChars);
}
