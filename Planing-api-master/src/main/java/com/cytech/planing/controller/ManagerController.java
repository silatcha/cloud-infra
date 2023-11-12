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
import com.cytech.planing.model.Manager;
import com.cytech.planing.service.ManagerService;

@RestController
@RequestMapping("/manager")
public class ManagerController {
	
	private final ManagerService managerService;

	public ManagerController(ManagerService managerService) {
		
		this.managerService = managerService;
	}
	
	@CrossOrigin
	@GetMapping("/all")
	public ResponseEntity<List<Manager>> getAllManager(){
		
		List<Manager> manager = this.managerService.findAllManager();
		
		return new ResponseEntity<>(manager,HttpStatus.OK);
		
	}
	
	
	@CrossOrigin
	@GetMapping("/find/{id}")
	public ResponseEntity<Manager> getStudent(@PathVariable("id") Long managerId){
		
		Manager manager = this.managerService.findManagerByManagerId(managerId);
		
		return new ResponseEntity<>(manager,HttpStatus.OK);
		
	}
	
	
	@CrossOrigin
	@PostMapping("/add")
	public ResponseEntity<Manager> saveManager(@RequestBody Manager manager){
		
		Manager newManager = this.managerService.addManager(manager);
		
		return new ResponseEntity<>(newManager,HttpStatus.CREATED);
		
	}
	
	
	@CrossOrigin
	@PostMapping("/login")
	public ResponseEntity<Manager> login(@RequestBody LoginBean login){
		
		Manager newManager = this.managerService.login(login.getEmail(),login.getPassword());
		
		return new ResponseEntity<>(newManager,HttpStatus.CREATED);
		
	}
	
	
	@CrossOrigin
	@PutMapping("/update")
	public ResponseEntity<Manager> updateManager(@RequestBody Manager manager){
		
		Manager newManager = this.managerService.updateManager(manager);
		
		return new ResponseEntity<>(newManager,HttpStatus.OK);
		
	}
	
	
	@CrossOrigin
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable("id") Long managerId){
		
		this.managerService.deleteManager(managerId);
		
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	

}
