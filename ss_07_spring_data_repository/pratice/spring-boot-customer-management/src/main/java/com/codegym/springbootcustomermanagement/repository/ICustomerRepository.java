package com.codegym.springbootcustomermanagement.repository;

import com.codegym.springbootcustomermanagement.model.Customer;
import com.codegym.springbootcustomermanagement.model.Province;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends PagingAndSortingRepository<Customer,Long> {
    Iterable<Customer> findAllByProvince(Province province);
}
