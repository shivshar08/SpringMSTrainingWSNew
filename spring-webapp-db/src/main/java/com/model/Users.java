package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="qual_users")
public class Users {
	
	@Id
	@GeneratedValue
	private int uId;
	
	private String uname;
	private String pass;
	private String email;
	private String city;
	
	public Users() {
		super();
	}

	public Users(int uId, String uname, String pass, String email, String city) {
		super();
	//	this.uId = uId;
		this.uname = uname;
		this.pass = pass;
		this.email = email;
		this.city = city;
	}
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
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
