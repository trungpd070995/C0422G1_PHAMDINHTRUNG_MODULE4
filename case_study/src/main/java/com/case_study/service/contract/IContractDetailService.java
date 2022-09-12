package com.case_study.service.contract;

import com.case_study.model.contract.ContractDetail;

import java.util.List;

public interface IContractDetailService {
    void create(ContractDetail contractDetail);

    List<ContractDetail> findAllByContract_contractId (Integer id);
}
