package com.case_study.service.contract;

import com.case_study.model.contract.ContractDetail;
import com.case_study.repository.contract.IContractDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailService implements IContractDetailService{
    @Autowired
    private IContractDetailRepository iContractDetailRepository;

    @Override
    public void create(ContractDetail contractDetail) {
        iContractDetailRepository.save(contractDetail);
    }

    @Override
    public List<ContractDetail> findAllByContract_contractId(Integer id) {
        return iContractDetailRepository.findAllByContract_contractId(id);
    }
}
