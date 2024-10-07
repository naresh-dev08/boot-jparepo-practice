package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.nt.entity.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
	
	//@Query("from Customer")
	//@Query("from Customer cust")
	//@Query("select * from Customer cust") //Runtime error coz *
	//@Query("select cust from Customer cust")
	@Query("select cust from Customer as cust")
	public List<Customer> getAllCustomers();
	
	//@Query("from Customer where billamt between ?1 and ?2")
	/*@Query("from Customer where billamt between :start and :end")
	public Iterable<Customer> getCustomersByBillAmountRange(@Param("start") float startAmount, @Param("end") float endAmount);*/
	
	//@Query("from Customer where billamt between :start and :end")
	//@Query("from Customer as cust where cust.billamt between :start and :end")
	//@Query("from Customer cust where cust.billamt between :start and :end")
	//@Query("from Customer cust where cust.billamt between ?1 and ?2") 
	//@Query("from Customer cust where cust.billamt between ?2 and ?1")     //working but reverse condition
	//@Query("from Customer cust where cust.billamt between ?1 and ?3")  //Runtime Error coz param sequence missing
   //@Query("from Customer cust where cust.billamt between ?0 and ?1")   //Runtime Error must start with 1
   //@Query("from Customer cust where cust.billamt between ? and ?")        //Runtime error coz (?) are not supported for JPA queries
   //@Query("from Customer cust where cust.billamt between :start and ?1") //runtime error
	/*@Query("from Customer cust where cust.billamt between ?1 and ?2")  
	public Iterable<Customer> getCustomersByBillAmountRange(float start, float end);*/
	
	//@Query("from Customer ?1 billamt between ?2 and ?3")  //cond = where runtime error, we con't pass where cond as param
	//@Query("from ?1 where billamt between ?2 and ?3")       //cond = Customer runtime error we con't pass class name as param
	/*public Iterable<Customer> getCustomersByBillAmountRange(String cond, float start, float end);*/
	
	
	@Query("select cid, cname, billamt from Customer where cname in(:name1, :name2)")  //Scalar projection (selecting specific multiple col values)
	public List<Object[]> getCustomersData(String name1, String name2);
	
	
	@Query("select cadd from Customer where cname like :initChars")
	public List<String> findCustomersAddrsByNameChars(String initChars);
	
	@Query(" from Customer where cadd = :addrs ")
	public Customer findCustomerDataByAddrs(String addrs);
	
	@Query(" select cid, cname, billamt from Customer where cadd = :addrs ")
	public Object findCustomerDetailsByAddrs(String addrs);
	
	@Query(" select cname from Customer where cadd = :addrs ")
	public String fetchCustomerNameByAddrs(String addrs);
	
	//@Query(" select count(*) from Customer ")
	@Query(" select count(distinct cadd) from Customer ")
	public int fetchAllCustomersCount();
	
	@Query(" select count(*), max(billamt), min(billamt), avg(billamt), sum(billamt) from Customer ")
	public Object fetchCustomersAggregateData();
	
	@Query(" update Customer set billamt = billamt + (billamt*:percentage/100.0f) where cadd in(:city1, :city2)")
	@Transactional
	@Modifying 
	public int updateCustomerBillAmountByAddtrsses(double percentage, String city1, String city2);
	
	@Query(" delete from Customer where billamt between :start and :end")
	@Transactional
	@Modifying 
	public int deleteCustomerByBillAmountRange(double start, double end);
}
