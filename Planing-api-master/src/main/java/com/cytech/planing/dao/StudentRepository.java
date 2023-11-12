package com.cytech.planing.dao;





import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import com.cytech.planing.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long>{

	void deleteStudentByStudentId(Long studentId);

	Student findByStudentId(Long studentId) throws Exception;

	//@Query("select * from Student u where u.email = :username or u.password = :password")
	Student findByEmailAndPassword( String email, String password) throws Exception;
	Student findByEmail( String email) throws Exception;
	Student findByPassword(String password) throws Exception;

}
