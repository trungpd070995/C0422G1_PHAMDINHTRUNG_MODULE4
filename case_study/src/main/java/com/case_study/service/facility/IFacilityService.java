package com.case_study.service.facility;

import com.case_study.model.customer.CustomerType;

import java.util.List;

public interface IFacilityService {
    List<CustomerType> findAll();

    void save(CustomerType customerType);
}
