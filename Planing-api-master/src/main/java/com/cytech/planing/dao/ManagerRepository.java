package com.cytech.planing.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cytech.planing.model.Manager;


@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {

	Manager findManagerByManagerId(Long managerId);

	void deleteManagerByManagerId(Long managerId);

	Manager findManagerByEmailAndPassword(String email, String password);

}
