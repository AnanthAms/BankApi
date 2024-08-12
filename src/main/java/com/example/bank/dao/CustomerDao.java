package com.example.bank.dao;

import java.util.List;
//import java.util.Optional;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.bank.entity.Customer;
import com.example.bank.repository.CustomerRepository;

@Repository
public class CustomerDao {

	@Autowired
	CustomerRepository cr;
	
	public String postDetails( List<Customer>a) {
		 cr.saveAll(a);
		 return "Posted Successfully";
	}
	
	public List<Customer> getAll(){
		return cr.getAll();
	}
	
	public List<Customer>getByAccType(String t){
		return cr.getByAccType(t);
	}
	
	public List<Customer> getByType(String x) throws Exception {
		return cr.getByType(x);
	}
	
	public List<Customer> getByAge(int a,int b) throws Exception {
		return cr.getByAge(a,b);
	}
	
	public String postNew( Customer v){
		 cr.save(v);
		 return "Added successfully";
		 
	}
	
	public List<Customer> getNames(String l) throws Exception {
		return cr.getNames(l);
	}
	
	public Customer getById(int i) {
		return cr.findById(i).get();
	}
	
//	public Optional<Customer> checkLength(Customer p) throws Exception{
//		return cr.getAll();
//	}
}
