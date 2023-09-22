package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.Users;
import com.service.UserService;

@RestController
@RequestMapping("/mainapp")
public class AppController {
	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public String loginValid(@ModelAttribute Users users) {
		System.out.println("=== Inside login post method ====");
		if(userService.validateCredentials(users.getUname(), users.getPass())) {
			return "login Success from service after Model restcontroller pkg";
		}
		return "login Failure";
	}
	

	@PostMapping("/registration")	
	public String registrationValid(@ModelAttribute Users users) {
		System.out.println("Inside post Mapping  => " +users);
		userService.addUser(users);
		return "Welcome to registeration model attr extra attr rest controller pkg";
	}
	
	@GetMapping("/loadAll")
	public List<Users> loadUsers(){
		return userService.loadAll();
	}
	
	@GetMapping("/finduser/{id}")
	public String findUser(@PathVariable int id) {
		if(userService.findUser(id)) {
			return  " User found";
		}
		return "not found";
	}
	
	@DeleteMapping("/deleteuser/{id}")
	public String deleteuser(@PathVariable int id) {
		if(userService.deleteUser(id)) {
			return "  found and deleted";
		}
		return "not found";
	}
	
	@PostMapping("/registrationRest")	
	public String registrationUsingRest(@RequestBody Users users) {
		System.out.println("Country => " + users);
		userService.addUser(users);
		return "User created using Rest invocation";
	}
	
	@PutMapping("/updateuser/{id}")
	public String updateuser(@PathVariable int id,@RequestBody Users users) {
		userService.updateUser(id,  users);
		return "  found and updated";		
	}
	
	//Using @RequestParam
	
//	@RequestMapping(value = "/registration", method = RequestMethod.POST)
//	@ResponseBody
//	public String registrationValid(@RequestParam("uname") String uname, @RequestParam("pass") String pass,
//			@RequestParam("email") String email, @RequestParam("city") String city) {
//		userService.addUser(new Users(uname, pass, email, city));
//		return "Welcome to registeration => " + uname + " :: " + email + " :: " + city;
//	}
}
