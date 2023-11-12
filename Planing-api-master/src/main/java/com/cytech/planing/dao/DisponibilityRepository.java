package com.cytech.planing.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cytech.planing.model.Teacher;
import com.cytech.planing.model.school.Disponibility;


@Repository
public interface DisponibilityRepository extends JpaRepository<Disponibility, Long> {

	
	List<Disponibility> findByTeacher(Teacher teacher);
	List<Disponibility> findAllByTeacherIsNull();
}
