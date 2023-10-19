package com.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import com.customer.entities.Customer;
import com.customer.services.CustomerServices;
import com.customer.repository.CustomerRepo;

import java.util.*;
@Controller
public class CustomerController {
	@Autowired
	private CustomerRepo customerRepo;
	@Autowired
	private CustomerServices customerServices;
	
	

	@GetMapping("/loginform")
	public String getLoginForm(Model model) {
		
		return "assignment_auth";
	}

	@GetMapping("/customers")
	public String getCustomerList(Model model) {
			List<Customer> list=this.customerServices.getAllData();
			model.addAttribute("list", list);
			System.out.println(list);
			return "assignment";	
	}

	@GetMapping("/customers/addCustomer")
	public String getAddCutomerForm(Model model){
		model.addAttribute("customerData", new Customer());
		return "addCustomer";
	}
	@PostMapping("/addCustomer")
	public String addCustomer(@ModelAttribute("customerData") Customer customer){
		this.customerServices.addCustomer(customer);
		return "redirect:/customers";
	}

	@GetMapping("/customers/delete/{id}")
    public String deleteEntity(@PathVariable("id") int id) {
        // Implement the logic to delete the entity from the database
        customerServices.deleteById(id);
        
        return "redirect:/customers"; // Replace "your-page" with the URL of the page where the table is displayed
    }
	@GetMapping("/customers/update/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Customer customer = customerRepo.findById(id);
        
        model.addAttribute("customer", customer);
        return "update";
    }
	@PostMapping("/updateProcess")
	public String updateData(@ModelAttribute("customer") Customer c) {
		customerServices.addCustomer(c);
		return "redirect:/customers";
	}


}
