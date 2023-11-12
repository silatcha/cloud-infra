package com.cytech.planing.model.school;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.cytech.planing.model.Teacher;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@Entity
public class Disponibility {
	
	@Id @GeneratedValue
	@JsonProperty("dispoId")
	private Long dispoId;
	@JsonProperty("timeD")
	private String  timeD;
	@JsonProperty("timeF")
	private String  timeF;
	@JsonProperty("day")
	private String day;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="teacher", nullable=false)
	private Teacher teacher;
	
	
	
	
	
	public Disponibility(String timeD,String timeF, String day) {
		
		this.timeD = timeD;
		this.timeF = timeF;
		this.day = day;
	}
	
public Disponibility() {}


	public String getTimeD() {
		return timeD;
	}


	public void setTimeD(String time) {
		this.timeD = time;
	}
	
	public String getTimeF() {
		return timeF;
	}


	public void setTimeF(String time) {
		this.timeF = time;
	}


	public String getDay() {
		return day;
	}


	public void setDay(String day) {
		this.day = day;
	}


	public Long getDispoId() {
		return dispoId;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Disponibility that = (Disponibility) o;
		return this.dispoId == that.dispoId && this.timeD == that.timeD && this.timeF == that.timeF && this.day == that.day && this.teacher.equals(that.teacher);
	}

	@Override
	public int hashCode() {
		return Objects.hash(dispoId, timeD, timeF, day, teacher);
	}
}
