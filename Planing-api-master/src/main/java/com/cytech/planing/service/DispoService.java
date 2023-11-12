package com.cytech.planing.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cytech.planing.dao.DisponibilityRepository;
import com.cytech.planing.model.Teacher;
import com.cytech.planing.model.school.Disponibility;

@Service
public class DispoService {

	
	private final DisponibilityRepository dispo;

	public DispoService(DisponibilityRepository dispo) {
		
		this.dispo = dispo;
	}
	
	
	public Disponibility addDispo(Disponibility dispo) {
		
		return this.dispo.save(dispo);
	}
	
	
public List<Disponibility> listDispo(Teacher teacher) {
		
		return this.dispo.findByTeacher(teacher);
	}

	public List<Disponibility> listDispovide() {
		return this.dispo.findAllByTeacherIsNull();
	}
}
