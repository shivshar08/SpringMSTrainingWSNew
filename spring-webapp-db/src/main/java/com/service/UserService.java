package com.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UsersDao;
import com.model.Users;

import java.util.Optional;

@Service
public class UserService {
	ArrayList<Users> registerationList = new ArrayList<Users>();
	
	@Autowired
	private UsersDao dao;
	
	public void addUser(Users users) {
		//registerationList.add(users);
		System.out.println("Inside addUser service Before saving via dao to db");
		dao.save(users);
		
		System.out.println("Inside service");
		System.out.println(registerationList.toString());
	}
	
	public boolean findUser(int uid) {
		Optional<Users> data=dao.findById(uid);
		if(data.isPresent()) {
			return true;
		}
		return false;
	}
	
	public boolean validateCredentials(String uname, String pass) {
		 if(uname.equals("admin") && pass.equals("manager")) {
			 System.out.println("Validation successful inside service");
			   return true;
		   }
		  return false;
	}
	
	public ArrayList<Users> loadAll() {
		return (ArrayList<Users>)dao.findAll();
	}
	
	public boolean findUser(String name) {
		for(Users us:registerationList) {
			if(us.getUname().equals(name)) {
				return true;
			}		
		}
		return false;
	}
	public boolean deleteUser(int uid) {
		Optional<Users> data=dao.findById(uid);
		if(data.isPresent()) {
			dao.deleteById(uid);
			return true;
		}
		return false;
		
	}
	
	public void updateUser(int uid, Users users) {
		System.out.println("Inside updateUser service method before updating user");
		dao.updateUser(users.getUname(), users.getPass(), users.getEmail(), users.getCity(), uid);
		
	}

}
