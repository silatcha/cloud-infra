package com.cytech.planing.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cytech.planing.model.Event;
import com.cytech.planing.model.Speciality;
import com.cytech.planing.model.Teacher;


@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

 List<Event> findByDay(String day);
 
 List<Event> findBySpeciality(Speciality speciality);
 
 List<Event> findByTeacher(Teacher teacher);
	
}
