package com.cytech.planing.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cytech.planing.model.Speciality;


@Repository
public interface SpecialityRepository extends JpaRepository<Speciality, Long> {

	//Speciality findBySpecialityId(Long specialityId);
	
}
