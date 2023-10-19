package com.customer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.entities.Customer;
import com.customer.repository.CustomerRepo;

import java.util.*;
@Service
public class CustomerServices {
	@Autowired
	private CustomerRepo customerRepo;
    public void addCustomer(Customer customer) {
		customerRepo.save(customer);
    }
	public List<Customer> getAllData() {
		List<Customer> list=(List<Customer>) this.customerRepo.findAll();
		return list;
	}
	public void deleteById(int id) {
		customerRepo.deleteById(id);
	}
	
	
}
