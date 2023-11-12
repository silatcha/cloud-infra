package com.cytech.planing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cytech.planing.dao.MatterRepository;
import com.cytech.planing.dao.SpecialityRepository;
import com.cytech.planing.model.Matter;
import com.cytech.planing.model.Speciality;

@Service
public class SpecialityService {

	
	@Autowired
	private final SpecialityRepository specialityRepository;
	@Autowired
	MatterRepository matterRepo;
	
	@Autowired
	public SpecialityService(SpecialityRepository specialityRepository,MatterRepository matter) {
		this.specialityRepository=specialityRepository;
		this.matterRepo=matter;
	}
	

	public Speciality addSpeciality(Speciality speciality,Long matterId) {
		
		Matter m=	this.matterRepo.findByMatterId(matterId);
		
		speciality.getMatter().add(m);
		
		m.getSpeciality().add(speciality);
		
		return this.specialityRepository.save(speciality);
	}
	
    public List<Speciality> findAllSpeciality() {
		
		return this.specialityRepository.findAll();
	}
}
