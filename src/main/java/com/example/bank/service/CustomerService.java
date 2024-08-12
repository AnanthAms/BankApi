package com.example.bank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.bank.dao.CustomerDao;
import com.example.bank.entity.Customer;
import com.example.bank.exception.AccTypeNotFoundException;
import com.example.bank.exception.AgeException;
import com.example.bank.exception.AgeNotFoundException;
import com.example.bank.exception.IdNotFoundException;

@Service
public class CustomerService {

	@Autowired
	CustomerDao cd;
	
	public String postDetails( List<Customer>a) {
		return cd.postDetails(a);
	}
	
	public List<Customer> getAll(){
		return cd.getAll();
	}
	
	public List<Customer>getByAccType(String t){
		return cd.getByAccType(t);
	}
	
	public List<Customer> getByType(String x) throws Exception {
		if(cd.getByAccType(x).isEmpty()) {
			throw new AccTypeNotFoundException("This type is not found in DB");
		}else {
			return cd.getByType(x);
		}
	}
	
	public List<Customer> getByAge(int a,int b) throws Exception {
		if(cd.getByAge(a, b).isEmpty() ){
			throw new AgeNotFoundException("Age is not in range");
		}else {
			return cd.getByAge(a, b);
		}
	}
	
	public String postNew(Customer v)throws Exception {
		if(v.getAge()<18) {
			throw new AgeException("Age is under 18");
		}else {
			return cd.postNew(v);
		}
	}
	
	public List<Customer> getNames(String l) throws Exception {
		if(cd.getNames(l).isEmpty()) {
			throw new NullPointerException("This name is not found in DB");
		}else {
			return cd.getNames(l);
		}
	}
    
	
	public Customer getById( int i) {
		return cd.getById(i);
		
	}
	
//	public Optional<Customer> checkLength(Customer p)throws Exception{
//	  )
//	}
}
