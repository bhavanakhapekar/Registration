package com.example.doa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Student;

public interface StudentDAOInterface extends JpaRepository<Student, Long>{

	public Student findByEmail(String email);
	
	
	

}
