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

import com.cytech.planing.model.Matter;

import com.cytech.planing.service.MatterService;


@RestController
@RequestMapping("/matter")
public class MatterController {

	

	private final MatterService matterService;

	public MatterController(MatterService matterService) {
		
		this.matterService = matterService;
	}
	
	@CrossOrigin
	@GetMapping("/all")
	public ResponseEntity<List<Matter>> getAllMatter(){
		
		List<Matter> matter = this.matterService.findAllMatter();
		
		return new ResponseEntity<>(matter,HttpStatus.OK);
		
	}
	
	@CrossOrigin
	@GetMapping("/one/{matterId}")
	public ResponseEntity<Matter> getMatter(@PathVariable("matterId") Long matterId){
		
		Matter matter = this.matterService.findMatter(matterId);
		
		return new ResponseEntity<>(matter,HttpStatus.OK);
		
	}
	
	
	
	
	@CrossOrigin
	@PostMapping("/add")
	public ResponseEntity<Matter> saveMatter(@RequestBody Matter matter){
		
		Matter newMatter = this.matterService.addMatter(matter);
		
		return new ResponseEntity<>(newMatter,HttpStatus.CREATED);
		
	}
	
	
}
