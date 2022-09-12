package com.case_study.service.contract;

import com.case_study.model.contract.AttachFacility;

import java.util.List;

public interface IAttachFacilityService {
    List<AttachFacility> findAllAttachFacility();
    List<AttachFacility> findAllById(int id);
}
