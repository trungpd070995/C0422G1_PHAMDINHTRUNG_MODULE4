package com.case_study.repository.contract;

import com.case_study.model.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IContractDetailRepository extends JpaRepository<ContractDetail, Integer> {
    List<ContractDetail> findAllByContract_contractId (Integer id);
}
