package com.cytech.planing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cytech.planing.dao.RoomRepository;

import com.cytech.planing.model.Room;

@Service
public class RoomService {

	
	
	@Autowired
	private final RoomRepository roomRepo;

	
	@Autowired
	public RoomService(RoomRepository roomRepo)
	{
		
		this.roomRepo= roomRepo;
		
		
	}
	
	public Room addRoom(Room room) {
		
		
		Room newRoom =this.roomRepo.save(room);
		
		
		return newRoom;
		
	}
	
    public List<Room> findAllRoom() {
		
		return this.roomRepo.findAll();
	}
    


    public Room updateRoom(Room room) {
		
		return this.roomRepo.save(room);
	}
    
    
public List<Room> findByCapacity(int capacity) {
		
		return this.roomRepo.findByCapacity(capacity);
	}

public Room findByName(String name) {
	
	return this.roomRepo.findByName(name);
}
    
    public void deleteTeacher(Long roomId) {
		
		// this.matterRepo.deleteStudentByTeacherId(teacherId);
	}
}
