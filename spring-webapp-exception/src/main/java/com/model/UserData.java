package com.model;

import java.util.ArrayList;
import java.util.List;

public class UserData {
	
	private List<Users> userList;
	
	public List<Users> getUserList(){
		if(userList == null) {
			userList = new ArrayList<Users>();
		}
		return userList;
	}

}
