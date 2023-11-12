package com.cytech.planing.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cytech.planing.model.Room;

import com.cytech.planing.service.RoomService;

@RestController
@RequestMapping("/room")
public class RoomController {
	
	
	
	private final RoomService roomService;

	public RoomController(RoomService roomService) {
		
		this.roomService = roomService;
	}
	
	@CrossOrigin
	@GetMapping("/all")
	public ResponseEntity<List<Room>> getAllRoom(){
		
		List<Room> room = this.roomService.findAllRoom();
		
		return new ResponseEntity<>(room,HttpStatus.OK);
		
	}
	
	
	
	
	@CrossOrigin
	@PostMapping("/add")
	public ResponseEntity<Room> saveRoom(@RequestBody Room matter){
		
		Room newMatter = this.roomService.addRoom(matter);
		
		return new ResponseEntity<>(newMatter,HttpStatus.CREATED);
		
	}
	
	
	@CrossOrigin
	@PutMapping("/update")
	public ResponseEntity<Room> updateRoom(@RequestBody Room room){
		
		Room newRoom = this.roomService.updateRoom(room);
		
		return new ResponseEntity<>(newRoom,HttpStatus.CREATED);
		
	}
	
	@CrossOrigin
	@GetMapping("/capacity/{capacity}")
	public ResponseEntity<List<Room>> getRoomByCapacity(@PathVariable("capacity") int capacity){
		
		List<Room> room = this.roomService.findByCapacity(capacity);
		
		return new ResponseEntity<>(room,HttpStatus.CREATED);
		
	}
	
	@CrossOrigin
	@GetMapping("/name/{name}")
	public ResponseEntity<Room> getRoomByName(@PathVariable("name") String name){
		
		Room room = this.roomService.findByName(name);
		
		return new ResponseEntity<>(room,HttpStatus.CREATED);
		
	}

}
