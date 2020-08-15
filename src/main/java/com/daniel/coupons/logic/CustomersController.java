package com.daniel.coupons.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.daniel.coupons.beans.Customer;
import com.daniel.coupons.dao.ICustomersDao;
import com.daniel.coupons.enums.ErrorType;
import com.daniel.coupons.exceptions.ApplicationException;
import com.daniel.coupons.utils.Utils;

@Controller
public class CustomersController {

	@Autowired
	private ICustomersDao customersDao;


	public CustomersController() {

	}

	public void createCustomer(Customer customer) throws ApplicationException {
		// Validation
		if (customer == null) {
			throw new ApplicationException(ErrorType.INVALID_CUSTOMER,"A null customer");
		}

		if(customer.getName() == "") {
			throw new ApplicationException(ErrorType.INVALID_CUSTOMER,"Blank name");
		}


		if(!Utils.isEmailValid(customer.getEmail())) {
			throw new ApplicationException(ErrorType.INVALID_EMAIL,"Invalid email address");
		}


		try {
			this.customersDao.save(customer);
		}
		catch (Exception e) {
			throw new ApplicationException(ErrorType.INVALID_COUPON,"General Error");
		}
	}

	public void removeCustomer(long id) throws ApplicationException {

		try {
			Customer customer = getCustomer(id);
			customersDao.delete(customer);
		}
		catch (Exception e) {
			throw new ApplicationException(ErrorType.INVALID_COUPON,"General Error");
		}
	}


	public Customer getCustomer(long companyId) throws ApplicationException {

		try {
			Customer customer = customersDao.findById(companyId).get();
			return customer;
		}
		catch (Exception e) {
			throw new ApplicationException(ErrorType.INVALID_COUPON,"General Error");
		}
	}

	public void updateCustomer(Customer customer) throws ApplicationException {

		try {
			this.customersDao.save(customer);
		}
		catch (Exception e) {
			throw new ApplicationException(ErrorType.INVALID_COUPON,"General Error");
		}
	}

	public List<Customer> getAllCustomers() throws ApplicationException {

		try {
			return this.customersDao.getAllCustomers();
		}
		catch (Exception e) {
			throw new ApplicationException(ErrorType.INVALID_COUPON,"General Error");
		}
	}

	public List<Customer> getAllCustomersByMinAge(int minAge) throws ApplicationException {

		try {
			return this.customersDao.getAllCustomersByMinAge(minAge);
		}
		catch (Exception e) {
			throw new ApplicationException(ErrorType.INVALID_COUPON,"General Error");
		}
	}
}





