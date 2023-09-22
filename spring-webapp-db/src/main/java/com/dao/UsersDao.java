package com.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.model.Users;

@Repository
public interface UsersDao extends CrudRepository<Users, Integer> {
	
	@Transactional
	@Modifying
	@Query("update Users c set c.uname=:uname, c.pass=:pass, c.email=:email, c.city=:city where c.uId=:uid")
	public int updateUser(String uname,String pass, String email, String city, int uid ); 

}
