package com.daniel.coupons.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.daniel.coupons.beans.Purchase;

public interface IPurchasesDao extends CrudRepository<Purchase, Long> {
	
	@Query("SELECT p FROM Purchase p WHERE customerId = :customerId")
	public List<Purchase> getAllPurchasesByCustomerID(@Param("customerId")long customerId);

	@Query("SELECT p FROM Purchase p WHERE couponId = :couponId")
	public List<Purchase> getAllPurchasesByCouponID(long couponId);

}
