package com.case_study.service.contract;

import com.case_study.model.contract.AttachFacility;
import com.case_study.repository.contract.IAttachFacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachFacilityService implements IAttachFacilityService{

    @Autowired
    private IAttachFacilityRepository iAttachFacilityRepository;

    @Override
    public List<AttachFacility> findAllAttachFacility() {
        return iAttachFacilityRepository.findAll();
    }

    @Override
    public List<AttachFacility> findAllById(int id) {
        return iAttachFacilityRepository.findAllAttachFacility(id);
    }
}
