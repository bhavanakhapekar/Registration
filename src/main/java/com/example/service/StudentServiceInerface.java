package com.example.service;

import com.example.model.Student;

public interface StudentServiceInerface {
	
	public Student AddStudentData(Student student);
	
	
	
	public Student ShowStudentDetails(long id);
	
	public Student searchByEmail(String email);
	
	
	

}
