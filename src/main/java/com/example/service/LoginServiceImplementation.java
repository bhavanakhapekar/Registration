package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.doa.LoginDAOInterface;
import com.example.model.Login;

@Service
public class LoginServiceImplementation implements LoginServiceInterface{
	
	@Autowired
	private LoginDAOInterface ld;

	@Override
	public Login findLoginDetais(String username, String password) {
		Login l=ld.findByUsernameAndPassword(username, password);
		return l;
	}

}
