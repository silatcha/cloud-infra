package com.cytech.planing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cytech.planing.model.Student;
import com.cytech.planing.dao.StudentRepository;


@Service
public class StudentService {
	
	@Autowired
	private final StudentRepository studentRepo;
	
	@Autowired
	public StudentService(StudentRepository studentRepo)
	{
		
		this.studentRepo= studentRepo;
		
	}
	
	public Student addStudent(Student student) {
		
		return this.studentRepo.save(student);
	}
	
    public List<Student> findAllStudent() {
		
		return this.studentRepo.findAll();
	}
    
public Student findStudentBySutendId(Long studentId) throws Exception {
		
		return this.studentRepo.findByStudentId(studentId);
	}


public Student login(String email,String password) throws Exception {
	
	return this.studentRepo.findByEmailAndPassword(email,password);
}


    public Student updateStudent(Student student) {
		
		return this.studentRepo.save(student);
	}
    
    public void deleteStudent(Long studentId) {
		
		 this.studentRepo.deleteStudentByStudentId(studentId);
	}
    
}
