package com.cytech.planing.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Manager extends User implements Serializable{

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Long managerId;

	public Manager(
			Long managerId) {
		
		this.managerId = managerId;
	}
	
	public Manager() {
		
	}

	public Long getStudentId() {
		return managerId;
	}
	
	
	
}
