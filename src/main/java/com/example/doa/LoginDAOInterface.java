package com.example.doa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Login;

@Repository
public interface LoginDAOInterface extends JpaRepository<Login, Long> {
	
	public Login findByUsernameAndPassword(String username, String password); 

}
