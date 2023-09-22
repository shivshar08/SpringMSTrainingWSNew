package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.Users;
import com.service.UserService;

@Controller
@RequestMapping("/mainapp")
public class ResController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		System.out.println("=== Inside login get method after split ====");
		return "login";
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration() {
		return "registration";
	}
	
//	@RequestMapping(value = "/registration", method = RequestMethod.POST)	
//	public String registrationValid(@ModelAttribute Users users) {
//		System.out.println("Country => " + users.getAddress().getCountry());
//		userService.addUser(users);
//		return "login";
//	}

}
