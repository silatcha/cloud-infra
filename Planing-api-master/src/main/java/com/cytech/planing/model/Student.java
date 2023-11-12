package com.cytech.planing.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Student extends User implements Serializable{
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	@JsonProperty("studentId")
	private Long studentId;
	@JsonProperty("schoolYear")
	private int schoolYear;
	@JsonProperty("speciality")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="specialityId", nullable=false)
	private Speciality speciality;

	

	public Student(
			Long studentId, int schoolYear, Speciality speciality) {
		super();
		this.studentId = studentId;
		this.schoolYear = schoolYear;
		this.speciality = speciality;
	}
	public Student() {
			
		super();
		
	}
	
	public int getSchoolYear() {
		return schoolYear;
	}

	public void setSchoolYear(int schoolYear) {
		this.schoolYear = schoolYear;
	}


	public Speciality getSpeciality() {
		return speciality;
	}
	public Long getStudentId() {
		return studentId;
	}
	
	
	
	

}
