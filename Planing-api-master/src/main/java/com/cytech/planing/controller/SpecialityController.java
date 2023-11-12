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

import com.cytech.planing.model.Speciality;

import com.cytech.planing.service.SpecialityService;

@RestController
@RequestMapping("/speciality")
public class SpecialityController {

	
	private final SpecialityService specialityService;

	public SpecialityController(SpecialityService specialityService) {
		
		this.specialityService = specialityService;
	}
	
	@CrossOrigin
	@GetMapping("/all")
	public ResponseEntity<List<Speciality>> getAllManager(){
		
		List<Speciality> speciality = this.specialityService.findAllSpeciality();
		
		return new ResponseEntity<>(speciality,HttpStatus.OK);
		
	}
	
	
	
	
	@CrossOrigin
	@PostMapping("/add/{matterId}")
	public ResponseEntity<Speciality> saveManager(@RequestBody Speciality speciality,@PathVariable("matterId") Long matterId){
		
		Speciality newManager = this.specialityService.addSpeciality(speciality,matterId);
		
		return new ResponseEntity<>(newManager,HttpStatus.CREATED);
		
	}
}
