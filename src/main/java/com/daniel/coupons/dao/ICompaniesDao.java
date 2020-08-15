package com.daniel.coupons.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.daniel.coupons.beans.Company;

public interface ICompaniesDao extends CrudRepository<Company, Long> {
	
	@Query("SELECT c FROM Company c")
	public List<Company> getAllCompanies();

}
