package com.cytech.planing.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cytech.planing.model.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
	
	void deleteStudentByTeacherId(Long teacherId);
 

	Teacher findByTeacherId(Long teacherId);



	Teacher findByEmailAndPassword(String email, String password);
	Teacher findByEmail(String email);




}
