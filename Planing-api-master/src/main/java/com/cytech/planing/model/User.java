package com.cytech.planing.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonProperty;




@MappedSuperclass
public  class User {
	
	
	@JsonProperty("firstName")
	private String firstName;
	@JsonProperty("email")
	private String email;
	@JsonProperty("phone")
	private int phone;
	@JsonProperty("lastName")
	private String lastName;
	@JsonProperty("password")
	private String password;
	@JsonProperty("role")
    @Column(nullable = false)
    private String role;
    
    
    
    
    
	
	public User() {
		
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	

   

	


}
