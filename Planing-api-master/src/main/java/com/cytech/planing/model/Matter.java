package com.cytech.planing.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
public class Matter {

	
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	@JsonProperty("matterId")
	private Long matterId;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("coef")
	private int coef;
	
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = { CascadeType.ALL },mappedBy = "matter")
	@JsonIgnore
	Set<Speciality> speciality= new HashSet<Speciality>();
	
	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JsonIgnore
		  private Set<Teacher> teacher = new HashSet<Teacher>();

	
	
	public Matter() {
		
	}

	public Matter(String name, int coef) {
		this.name = name;
		this.coef = coef;
		
	}
	
	
	
	 public Matter(String name, int coef, Set<Teacher> teachers) {
		super();
		this.name = name;
		this.coef = coef;
		this.teacher = teachers;
	}

	public void addTeacher(Teacher teacher) {
		    this.teacher.add(teacher);
		  }

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getCoef() {
		return coef;
	}


	public void setCoef(int coef) {
		this.coef = coef;
	}



	public Set<Teacher> getTeachers() {
		return teacher;
	}


	public void setTeachers(Set<Teacher> teachers) {
		this.teacher = teachers;
	}


	public Long getMatterId() {
		return matterId;
	}

	public Set<Speciality> getSpeciality() {
		return speciality;
	}

	public void setSpeciality(Set<Speciality> speciality) {
		this.speciality = speciality;
	}

	public Set<Teacher> getTeacher() {
		return teacher;
	}

	public void setTeacher(Set<Teacher> teacher) {
		this.teacher = teacher;
	}
	
	

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Matter subject = (Matter) o;
		return this.name == subject.name && this.matterId == subject.getMatterId();
	}

	@Override
	public int hashCode() {
		return Objects.hash(name,matterId) ;
	}

	

}
