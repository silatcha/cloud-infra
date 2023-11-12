package com.cytech.planing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cytech.planing.dao.DisponibilityRepository;
import com.cytech.planing.dao.MatterRepository;

import com.cytech.planing.model.Matter;


@Service
public class MatterService {

	
	@Autowired
	private final MatterRepository matterRepo;
	@Autowired
	DisponibilityRepository dispo;
	
	@Autowired
	public MatterService(MatterRepository matterRepo)
	{
		
		this.matterRepo= matterRepo;
		
		
	}
	
	public Matter addMatter(Matter matter) {
		
		
		Matter newMatter =this.matterRepo.save(matter);

		return newMatter;
		
	}
	
    public List<Matter> findAllMatter() {
		
		return this.matterRepo.findAll();
	}
    
    
public Matter findMatter(Long matterId) {
		
		return this.matterRepo.findByMatterId(matterId);
	}
    


    public Matter updateMatter(Matter matter) {
		
		return this.matterRepo.save(matter);
	}
    
    public void deleteTeacher(Long matterId) {
		
		// this.matterRepo.deleteStudentByTeacherId(teacherId);
	}
}
