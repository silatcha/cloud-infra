package com.cytech.planing.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cytech.planing.model.Matter;
import com.cytech.planing.model.Teacher;
import com.cytech.planing.dao.DisponibilityRepository;
import com.cytech.planing.dao.MatterRepository;
import com.cytech.planing.dao.TeacherRepository;


@Service
public class TeacherService {

	
	@Autowired
	private final TeacherRepository teacherRepo;
	@Autowired
	MatterRepository dispo;
	
	@Autowired
	public TeacherService(TeacherRepository teacherRepo,MatterRepository dispo)
	{
		
		this.teacherRepo= teacherRepo;
		this.dispo=dispo;
		
		
	}
	
	public Teacher addTeacher(Teacher teacher,Long matterId) {
		
	Matter m=	this.dispo.findByMatterId(matterId);
	
	
	
		teacher.getMatter().add(m);
		
		m.getTeachers().add(teacher);
		
		Teacher newTeacher =this.teacherRepo.save(teacher);

		
		
		return newTeacher;
		
	}
	
    public List<Teacher> findAllTeacher() {
		
		return this.teacherRepo.findAll();
	}
    
public Teacher findTeacherByTeacherId(Long teacherId) {
		
		return this.teacherRepo.findByTeacherId(teacherId);
	}


public Teacher login(String email,String password) {
	
	return this.teacherRepo.findByEmailAndPassword(email,password);
}



    public Teacher updateTeacher(Teacher teacher) {
		
    	
		return this.teacherRepo.save(teacher);
	}
    
    public void deleteTeacher(Long teacherId) {
		
		 this.teacherRepo.deleteStudentByTeacherId(teacherId);
	}
}
