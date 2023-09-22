package com.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.model.Users;

@Service
public class UserService {
	ArrayList<Users> registerationList = new ArrayList<Users>();
	public void addUser(Users users) {
		registerationList.add(users);
		System.out.println("Inside service");
		System.out.println(registerationList.toString());
	}
	
	public boolean validateCredentials(String uname, String pass) {
		 if(uname.equals("admin") && pass.equals("manager")) {
			 System.out.println("Validation successful inside service");
			   return true;
		   }
		  return false;
	}
	
	public ArrayList<Users> loadAll() {
		return registerationList;
	}
	
	public boolean findUser(String name) {
		for(Users us:registerationList) {
			if(us.getUname().equals(name)) {
				return true;
			}		
		}
		return false;
	}
	public boolean deleteUser(String name) {
		for(Users us:registerationList) {
			if(us.getUname().equals(name)) {
				registerationList.remove(us);
				return true;
			}		
		}
		return false;
	}
	
	public void updateUser(String name, Users users) {
		for(Users us:registerationList) {
			if(us.getUname().equals(name)) {
				us.setUname(users.getUname());
				us.setEmail(users.getEmail());
				us.setPass(users.getPass());
				if(us.getCity() != null) {
					us.setCity(users.getCity());
				}
				
				//us.getAddress().setCountry(users.getAddress().getCountry());
				System.out.println("User updated successfully");
			}					
		}
	}

}
