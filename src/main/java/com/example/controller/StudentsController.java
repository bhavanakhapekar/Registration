package com.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Login;
import com.example.model.Student;
import com.example.service.LoginServiceInterface;
import com.example.service.StudentServiceInerface;

@RestController
@RequestMapping("/student")
public class StudentsController {
	
	@Autowired
	private StudentServiceInerface ss;
	
	@Autowired
	private LoginServiceInterface ls;
	
	@PostMapping("/addStudentDetail")
	public ResponseEntity<Object> addNewStudent(@Valid @RequestBody Student student){
		ss.AddStudentData(student);
		return new ResponseEntity<>(student, HttpStatus.OK);
		}
	
	
	@GetMapping("/loginStudent/{username}/{password}")
	public ResponseEntity<Object> loginStudent(@Valid @PathVariable String username, @PathVariable String password){
		Login l=ls.findLoginDetais(username, password);
		long login_id=l.getLoginId();
		
		Student s=ss.ShowStudentDetails(login_id);
		if (s==null) {
			return new ResponseEntity<>(s, HttpStatus.BAD_REQUEST);
		}else
		return new ResponseEntity<>(s, HttpStatus.OK);
		
	}
	
}
