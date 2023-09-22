package com.model;

public class Users {
	private String uname;
	private String pass;
	private String email;
	private Address address;
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Users(String uname, String pass, String email, String city,Address address) {
		super();
		this.uname = uname;
		this.pass = pass;
		this.email = email;		
		this.address= address;
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
		return "Users [uname=" + uname + ", pass=" + pass + ", email=" + email + ", address=" + address + "]";
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
