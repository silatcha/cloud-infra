package com.cytech.planing.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Room {

	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	@JsonProperty("roomId")
	private Long roomId;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("capacity")
	private int capacity;
	
	@JsonProperty("state")
	private boolean state;

	
	public Room() {
		
	}
	
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public Long getRoomId() {
		return roomId;
	}
	
	
	
	
	
}
