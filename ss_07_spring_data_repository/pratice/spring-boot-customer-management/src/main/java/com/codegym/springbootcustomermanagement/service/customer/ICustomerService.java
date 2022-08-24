package com.codegym.springbootcustomermanagement.service.customer;

import com.codegym.springbootcustomermanagement.model.Customer;
import com.codegym.springbootcustomermanagement.model.Province;
import com.codegym.springbootcustomermanagement.service.IGeneralService;

public interface ICustomerService extends IGeneralService<Customer> {

    Iterable<Customer> findAllByProvince(Province province);

}
