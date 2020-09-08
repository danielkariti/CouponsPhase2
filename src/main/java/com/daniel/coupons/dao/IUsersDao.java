package com.daniel.coupons.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.daniel.coupons.beans.User;

public interface IUsersDao extends CrudRepository<User, Long> {

	@Query("SELECT u FROM User u WHERE username = :username")
	public User findByUsername(@Param("username") String username);

	@Query("SELECT u FROM User u")
	public List<User> getAllUsers();

	@Query("SELECT u FROM User u WHERE company.id = :companyId")
	public List<User> getAllUsersByCompanyID(@Param("companyId")long companyId);

//	@Query("SELECT u FROM User u WHERE username = :username AND password = :password")
//	public User findByUsernameAndPassword(String username, String password);



}
