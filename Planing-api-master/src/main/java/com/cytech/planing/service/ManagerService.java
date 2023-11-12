package com.cytech.planing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cytech.planing.model.Manager;
import com.cytech.planing.dao.ManagerRepository;

@Service
public class ManagerService {
	
	@Autowired
	private final ManagerRepository managerRepository;
	
	@Autowired
	public ManagerService(ManagerRepository managerRepository) {
		this.managerRepository=managerRepository;
	}
	

	public Manager addManager(Manager manager) {
		
		return this.managerRepository.save(manager);
	}
	
    public List<Manager> findAllManager() {
		
		return this.managerRepository.findAll();
	}
    
public Manager findManagerByManagerId(Long managerId) {
		
		return this.managerRepository.findManagerByManagerId(managerId);
	}

public Manager login(String email,String password) {
	
	return this.managerRepository.findManagerByEmailAndPassword(email,password);
}

    public Manager updateManager(Manager managerId) {
		
		return this.managerRepository.save(managerId);
	}
    
    public void deleteManager(Long managerId) {
		
		 this.managerRepository.deleteManagerByManagerId(managerId);
	}

}
