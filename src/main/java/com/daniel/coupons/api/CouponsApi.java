package com.daniel.coupons.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.coupons.beans.Coupon;
import com.daniel.coupons.enums.Category;
import com.daniel.coupons.exceptions.ApplicationException;
import com.daniel.coupons.logic.CouponsController;


@RestController
@RequestMapping("/coupon")
public class CouponsApi {

	@Autowired
	private CouponsController couponsController;

	@PostMapping
	public void createCoupon(@RequestBody Coupon coupon) throws ApplicationException {
		this.couponsController.createCoupon(coupon);

	}
	@PutMapping
	public void updateCoupon(Coupon coupon) throws ApplicationException {
		this.couponsController.updateCoupon(coupon);
	}

	@GetMapping("/{id}")
	public Coupon getCoupon(@PathVariable("id") long id) throws ApplicationException {
		return this.couponsController.getCoupon(id);
	}

	@DeleteMapping("/{id}")
	public void removeCoupon(@PathVariable("id") long id) throws ApplicationException {
		this.couponsController.removeCoupon(id);
	}

	@GetMapping
	public List<Coupon> searchCoupons(Long company, String category) throws ApplicationException {
		if (company!=null) {
			return this.couponsController.getAllCouponsByCompanyId(company);
		} 
		else if(category!= null) {
			Category categoryName = Category.valueOf(category.toUpperCase());
			return this.couponsController.findByCategory(categoryName);
		}
		else {
			return this.couponsController.getAllCoupons();
		}
	}
}