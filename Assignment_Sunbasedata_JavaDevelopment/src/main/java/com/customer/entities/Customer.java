package com.customer.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;


@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cid;
	
	@NotBlank(message = "firstname is missing")
	private String firstName;
	@NotBlank(message = "lastname is missing")
	private String lastName;
	private String address;
	private String state;	
	private String city;
	private String email;
	private String phoneNumber;
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Customer(int cid, String firstName, String lastName, String address, String state, String city, String email,
			String phoneNumber) {
		this.cid = cid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.state = state;
		this.city = city;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", state=" + state + ", city=" + city + ", email=" + email + ", phoneNumber=" + phoneNumber + "]";
	}
	
	
	
	

}
