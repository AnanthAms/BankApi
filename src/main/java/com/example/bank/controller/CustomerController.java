package com.example.bank.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bank.entity.Customer;
import com.example.bank.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService cs;
	
	@PostMapping(value="/post")
	public String postDetails(@RequestBody List<Customer> a) {
		return cs.postDetails(a);
	}
	
	@GetMapping(value="/get")
	public List<Customer> getAll(){
		return cs.getAll();
	}
	
	@GetMapping (value="/getAcType/{t}")
	public List<Customer>getByAccType(@PathVariable String t){
		return cs.getByAccType(t);
	}
	
	@GetMapping (value="/excep/{x}")
	public List<Customer> getByType(@PathVariable String x) throws Exception {
		return cs.getByType(x);
	}
	
	@GetMapping(value="/age/{a}/{b}")
	public List<Customer> getByAge(@PathVariable int a, @PathVariable int b) throws Exception {
		return cs.getByAge(a,b);
	}
	
	@PostMapping(value="/add")
	public String postNew(@RequestBody Customer v) throws Exception{
		return cs.postNew(v);
	}
	
	@GetMapping(value="/name/{l}")
	public List<Customer> getNames(@PathVariable String l) throws Exception {
		return cs.getNames(l);
	}
	
	@GetMapping(value="/searchById/{i}")
	public Customer getById(@PathVariable int i) {
		return cs.getById(i);
	}
	 
//	@GetMapping(value="/check")
//	public Optional<Customer> checkLength(Customer p) throws Exception{
//		return cs.checkLength(p);
//	}
}
