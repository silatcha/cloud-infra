package com.cytech.planing.model;

import java.io.Serializable;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.cytech.planing.model.school.Disponibility;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
public class Teacher extends User implements Serializable {

	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Long teacherId;
	
	@OneToMany(mappedBy="teacher")
	private List<Disponibility> disponibility= new ArrayList<>();
	
	@OneToMany(mappedBy="teacher")
	private List<Event> event= new ArrayList<Event>();

	@ManyToMany(fetch = FetchType.LAZY,
			cascade = { CascadeType.ALL },mappedBy = "teacher")
	@JsonIgnore
	Set<Matter> matter= new HashSet<Matter>();

	public Teacher() {
		
	}

	



	public Set<Matter> getMatter() {
		return matter;
	}





	public void setMatter(Set<Matter> matter) {
		this.matter = matter;
	}





	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}





	public Long getTeacherId() {
		return teacherId;
	}



	public List<Disponibility> getDisponibility(List<Disponibility> dispo) {
		
		return dispo;
	}
	public boolean isAvailable (Disponibility t) {
		for (Disponibility availableTimeslot : disponibility) {
			if (availableTimeslot.getDay().equals(t.getDay()) && availableTimeslot.getTimeD().equals(t.getTimeD())
					&& availableTimeslot.getTimeF().equals(t.getTimeF())
			) {
				return true;
			}
		}
		return false;
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Teacher teacher = (Teacher) o;
		return this.teacherId == teacher.teacherId && this.disponibility.equals(teacher.disponibility) ;
	}

	@Override
	public int hashCode() {
		return Objects.hash(teacherId, disponibility);
	}
	
	
	
	
}
