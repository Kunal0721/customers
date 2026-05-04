package com.work.Customers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.work.Customers.model.Customers;
import com.work.Customers.service.CustomerService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class CustomerController {

	@Autowired
	private CustomerService service;

	@GetMapping
	public List<Customers> getAll() {
		return service.getAll();
	}
	
	@GetMapping("/test")
	public String testAPi() {
		return "test api";
	}

	@GetMapping("/{id}")
	public Customers getOne(@PathVariable Long id) {
		return service.getOne(id);
	}

	@PostMapping
	public Customers createCustomer(@RequestBody Customers cus) {
		return service.create(cus);
	}

	@PutMapping("/{id}")
	public Customers updateOne(@PathVariable Long id, @RequestBody Customers cus) {
		return service.update(id, cus);
	}

	@DeleteMapping("/{id}")
	public String deleteOne(@PathVariable Long id) {
		service.delete(id);
		return "Deleted successfully ...";
	}

}
