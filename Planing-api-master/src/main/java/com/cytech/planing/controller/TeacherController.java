package com.cytech.planing.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cytech.planing.loginBean.LoginBean;
import com.cytech.planing.model.Teacher;
import com.cytech.planing.service.TeacherService;


@RestController
@RequestMapping("/teacher")
public class TeacherController {

	
	private final TeacherService teacherService;

	public TeacherController(TeacherService teacherService) {
		super();
		this.teacherService = teacherService;
	}
	
	
	@CrossOrigin
	@GetMapping("/all")
	public ResponseEntity<List<Teacher>> getAllTeacher(){
		
		List<Teacher> teacher = this.teacherService.findAllTeacher();
		
		return new ResponseEntity<>(teacher,HttpStatus.OK);
		
	}
	
	
	@CrossOrigin
	@GetMapping("/find/{id}")
	public ResponseEntity<Teacher> getTeacher(@PathVariable("id") Long teacheId){
		
		Teacher teacher = this.teacherService.findTeacherByTeacherId(teacheId);
		
		return new ResponseEntity<>(teacher,HttpStatus.OK);
		
	}
	
	
	@CrossOrigin
	@PostMapping("/login")
	public ResponseEntity<Teacher> login(@RequestBody LoginBean login){
		
		Teacher teacher = this.teacherService.login(login.getEmail(),login.getPassword());
		
		return new ResponseEntity<>(teacher,HttpStatus.OK);
		
	}
	
	
	@CrossOrigin
	@PostMapping("/add/{matterId}")
	public ResponseEntity<Teacher> saveTeacher(@RequestBody Teacher teacher,@PathVariable("matterId") Long matterId){
		
		Teacher newTeacher = this.teacherService.addTeacher(teacher,matterId);
		
		return new ResponseEntity<>(newTeacher,HttpStatus.CREATED);
		
	}
	
	
	@CrossOrigin
	@PutMapping("/update")
	public ResponseEntity<Teacher> updateStudent(@RequestBody Teacher teacher){
		
		Teacher newTeache = this.teacherService.updateTeacher(teacher);
		
		return new ResponseEntity<>(newTeache,HttpStatus.OK);
		
	}
	
	@CrossOrigin
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable("id") Long teacherId){
		
		this.teacherService.deleteTeacher(teacherId);
		
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
}
