package com.customer.repository;

import org.springframework.data.repository.CrudRepository;

import com.customer.entities.Customer;

public interface CustomerRepo extends CrudRepository<Customer, Integer>{
	public Customer findById(int id);
}
