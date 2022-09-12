package com.case_study.repository.contract;

import com.case_study.model.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractDetailRepository extends JpaRepository<ContractDetail, Integer> {

}
