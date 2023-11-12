package com.cytech.planing.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.cytech.planing.dao.EventRepository;
import com.cytech.planing.model.Event;
import com.cytech.planing.model.Speciality;
import com.cytech.planing.model.Teacher;


@Service
public class EventService {

	
	private final EventRepository eventRepo;

	public EventService(EventRepository eventRepo) {
		
		this.eventRepo = eventRepo;
	}
	
	
	public Event addEvent(Event event) {
		
		return this.eventRepo.save(event);
	}
	
	
public List<Event> findAllEvent() {
		
		return this.eventRepo.findAll();
	}
	

public List<Event> findBySpeciality(Long specialityId) {
	
	Speciality speciality= new Speciality();
	
	speciality.setSpecialityId(specialityId);
	
	return this.eventRepo.findBySpeciality(speciality);
}


public List<Event> findByTeacher(Long teacherId) {
	
	Teacher teacher= new Teacher();
	
	teacher.setTeacherId(teacherId);
	
	return this.eventRepo.findByTeacher(teacher);
}

public List<Event> findEventByDayEvent(String day) {
	
	return this.eventRepo.findByDay(day);
}
}
