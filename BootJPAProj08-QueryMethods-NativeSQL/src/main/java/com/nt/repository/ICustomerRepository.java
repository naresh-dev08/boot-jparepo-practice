package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.nt.entity.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
	
	//@Query(value = "INSERT INTO JPA_CUSTOMER_TAB VALUES(CUSTCID_SEQ.NEXTVAL, :billamt, :cadd, :cname)", nativeQuery = true) //  working
	@Query(value = "INSERT INTO JPA_CUSTOMER_TAB(CID, BILLAMT, CADD, CNAME) VALUES(CUSTCID_SEQ.NEXTVAL, :billamt, :add, :cname)", nativeQuery = true)
	@Modifying
	@Transactional
	public int insertCustomer(String cname, String add, double billamt);
	
	@Query(value = "CREATE TABLE TEMP1(Col1 NUMBER(5), Col2 NUMBER(10))", nativeQuery = true)
	@Modifying
	@Transactional
	public int createTempTable();
}
