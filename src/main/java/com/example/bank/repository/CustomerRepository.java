package com.example.bank.repository;

import java.util.List;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.bank.entity.Customer;

public interface CustomerRepository extends JpaRepository <Customer,Integer> {

	@Query(value="select * from customers",nativeQuery=true)
	public List<Customer> getAll();
	
	@Query(value="select * from customers where acctype = ?",nativeQuery=true )
	public List<Customer>getByAccType(String t);
	
	@Query(value="select * from customers where acctype = ?",nativeQuery=true)
	public List<Customer> getByType(String x);
	
	@Query(value="select * from customers where age>? && age <?",nativeQuery=true)
	public List<Customer> getByAge(int a,int b);

	@Query(value="select * from customers where name = ?",nativeQuery=true )
	public List<Customer> getNames(String l);
	
	@Query(value="select * from customers where slno = ?",nativeQuery=true )
	public Customer getById(int i);
	
//	@Query(value="select * from customer where name > ?",nativeQuery=true)
//	public List<Customer> checkLength(Customer p);
	
}
