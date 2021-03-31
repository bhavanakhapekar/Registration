package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.doa.StudentDAOInterface;
import com.example.model.Student;

@Service
public class StudentServiceImplemention implements StudentServiceInerface {
	
	@Autowired
	private StudentDAOInterface sd;

	@Override
	public Student AddStudentData(Student student) {
		System.out.println("In Student Service add method");
		Student s=sd.save(student);
		return s;
	}

	@Override
	public Student ShowStudentDetails(long id) {
		Student st=sd.findById(id).get();
		return st;
	}

	@Override
	public Student searchByEmail(String email) {
		Student st=sd.findByEmail(email);
		return st;
	}

	

	
	
}
