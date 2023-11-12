package com.cytech.planing.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cytech.planing.model.Matter;



@Repository
public interface MatterRepository extends JpaRepository<Matter, Long>{

	Matter findByMatterId(Long matterId);
}
