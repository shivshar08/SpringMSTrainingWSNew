package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dao.UserDao;
import com.model.UserData;
import com.model.Users;

@RestController
@RequestMapping("/mainapp")
public class AppController {
	@Autowired
	private UserDao dao;
	
	@GetMapping("/loadAll")
	public UserData loadUsers(
			@RequestHeader(name="X-COM-PERSIST",required=true) String headerPersist,
			@RequestHeader(name="X-COM-LOCATION",defaultValue = "ASIA") String headerLocation
			) {
		return dao.getAllUsers();
	}
	
	@PostMapping("/adduser")
	public ResponseEntity<Object> addUser(@RequestBody Users users){
		dao.addUser(users);
		return ResponseEntity.ok("User added successfully");		
		
	}

}
