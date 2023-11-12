package com.cytech.planing.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cytech.planing.model.Teacher;
import com.cytech.planing.model.school.Disponibility;
import com.cytech.planing.service.DispoService;


@RestController
@RequestMapping("/disponibility")
public class DisponibilityController {



	private final DispoService dispoService;



	public DisponibilityController(DispoService dispoService) {
		
		this.dispoService = dispoService;
	}
	
	@CrossOrigin
	@GetMapping("/all/{teacheId}")
	public ResponseEntity<List<Disponibility>> getAllDisponibility(@PathVariable("teacheId") Long teacheId){
		
		Teacher teacher= new Teacher();
		teacher.setTeacherId(teacheId);
		
		List<Disponibility> speciality = this.dispoService.listDispo(teacher);
		
		return new ResponseEntity<>(speciality,HttpStatus.OK);
		
	}
	
	
	
	
	@CrossOrigin
	@PostMapping("/add")
	public ResponseEntity<Disponibility> saveManager(@RequestBody Disponibility speciality){
		
		Disponibility newManager = this.dispoService.addDispo(speciality);
		
		return new ResponseEntity<>(newManager,HttpStatus.CREATED);
		
	}
	@CrossOrigin
	@GetMapping("/all")
	public ResponseEntity<Disponibility> getAllDisponibility(){

		List<Disponibility> all = this.dispoService.listDispovide();

		return new ResponseEntity(all,HttpStatus.CREATED);

	}

}
