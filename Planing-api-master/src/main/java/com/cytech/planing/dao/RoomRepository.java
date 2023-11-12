package com.cytech.planing.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cytech.planing.model.Room;

@Repository
public interface RoomRepository  extends JpaRepository<Room, Long> {

	
 List<Room>	findByCapacity(int capacity);
 Room findByName(String name);
}
