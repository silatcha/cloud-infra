package com.cytech.planing.controller;

import java.util.List;

import com.cytech.planing.model.school.Disponibility;
import com.cytech.planing.service.DispoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cytech.planing.controller.OptaplannerController;
import com.cytech.planing.model.Event;

import com.cytech.planing.service.EventService;


@RestController
@RequestMapping("/event")
public class EventController {

	
	private final EventService eventService;

	public EventController(EventService eventService) {
		
		this.eventService = eventService;
	}
	
	@CrossOrigin
	@GetMapping("/all")
	public ResponseEntity<List<Event>> getAllEvent(){
		
		List<Event> event = this.eventService.findAllEvent();
		
		return new ResponseEntity<>(event,HttpStatus.OK);
		
	}
		
	@CrossOrigin
	@GetMapping("/day/{day}")
	public ResponseEntity<List<Event>> getAllByDay(@PathVariable("day") String day){
		
		List<Event> event = this.eventService.findEventByDayEvent(day);
		
		return new ResponseEntity<>(event,HttpStatus.OK);
		
	}
	
	@CrossOrigin
	@GetMapping("/speciality/{specialityId}")
	public ResponseEntity<List<Event>> getAllBySpeciality(@PathVariable("specialityId") Long specialityId){
		
		List<Event> event = this.eventService.findBySpeciality(specialityId);
		
		return new ResponseEntity<>(event,HttpStatus.OK);
		
	}
	
	
	@CrossOrigin
	@GetMapping("/teacher/{teacherId}")
	public ResponseEntity<List<Event>> getAllByTeacher(@PathVariable("teacherId") Long teacherId){
		
		List<Event> event = this.eventService.findByTeacher(teacherId);
		
		return new ResponseEntity<>(event,HttpStatus.OK);
		
	}
	
	@CrossOrigin
	@PostMapping("/add")
	public ResponseEntity<Event> saveEvent(@RequestBody Event event){
		
		Event newEvent = this.eventService.addEvent(event);
		
		return new ResponseEntity<>(newEvent,HttpStatus.CREATED);
		
	}


}
