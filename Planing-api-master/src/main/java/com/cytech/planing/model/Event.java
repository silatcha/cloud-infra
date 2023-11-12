package com.cytech.planing.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Event {

	
	@Id @GeneratedValue
	@JsonProperty("eventId")
	private Long eventId;
	@JsonProperty("timeD")
	private String  timeD;
	@JsonProperty("timeF")
	private String  timeF;
	@JsonProperty("day")
	private String day;
	@JsonProperty("title")
	private String title;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="specialityId", nullable=false)
	private Speciality speciality;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="teacherId", nullable=false)
	@JsonProperty("teacher")
	private Teacher teacher;
	
	
	public Event() {
		super();
	}
	
	
	public String getTimeD() {
		return timeD;
	}
	public void setTimeD(String timeD) {
		this.timeD = timeD;
	}
	public String getTimeF() {
		return timeF;
	}
	public void setTimeF(String timeF) {
		this.timeF = timeF;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getEventId() {
		return eventId;
	}


	public Speciality getSpeciality() {
		return speciality;
	}


	public void setSpeciality(Speciality speciality) {
		this.speciality = speciality;
	}
	
	
	
}
