package com.cytech.planing.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import java.util.Set;

import java.util.Objects;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Speciality {

	
	
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	@JsonProperty("specialityId")
	private Long specialityId;
	
	@JsonProperty("name")
	private String name;
	
	@OneToMany(mappedBy="speciality")
	@JsonIgnore
	private  List<Event> event = new ArrayList<>();

	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JsonIgnore
		  private Set<Matter> matter = new HashSet<Matter>();
	

	private int groupSize;


	public Speciality() {
		super();
		
	}

	public Long getSpecialityId() {
		return specialityId;
	}

	public void setSpecialityId(Long specialityId) {
		this.specialityId = specialityId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Event> getEvent() {
		return event;
	}

	public void setEvent(List<Event> event) {
		this.event = event;
	}


	public Set<Matter> getMatter() {
		return matter;
	}

	public void setMatter(Set<Matter> matter) {
		this.matter = matter;
	}


	public int getGroupSize() {
		return groupSize;
	}


	public void setGroupSize(int groupSize) {
		this.groupSize = groupSize;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Speciality that = (Speciality) o;
		return groupSize == that.groupSize && this.name == that.name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, groupSize);
	}
	
	
	
}
