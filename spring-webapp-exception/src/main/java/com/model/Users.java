package com.model;

public class Users {
	private String uname;
	private String pass;
	private String email;
	private String city;

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Users(String uname, String pass, String email, String city) {
		super();
		this.uname = uname;
		this.pass = pass;
		this.email = email;		
		this.city= city;
	}
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPass() {
		return pass;
	}
	@Override
	public String toString() {
		return "Users [uname=" + uname + ", pass=" + pass + ", email=" + email + ", city=" + city + "]";
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}	
}
