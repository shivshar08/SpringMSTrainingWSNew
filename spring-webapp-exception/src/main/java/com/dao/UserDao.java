package com.dao;
import org.springframework.stereotype.Repository;

import com.model.UserData;
import com.model.Users;

@Repository
public class UserDao {

	private static UserData list = new UserData();
	
	static {
		list.getUserList().add(new Users("alex","alex123","alex@gmail.com","pune"));
		list.getUserList().add(new Users("mohan","mohan123","mohan@gmail.com","pune"));
		list.getUserList().add(new Users("dev","dev123","dev@gmail.com","pune"));
	}
	
	public UserData getAllUsers() {
		return list;
	}
	
	public void addUser(Users users) {
		list.getUserList().add(users);
	}
}
