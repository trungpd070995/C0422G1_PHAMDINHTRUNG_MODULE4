package com.case_study.service.contract;

import com.case_study.model.contract.AttachFacility;
import com.case_study.model.contract.Contract;
import com.case_study.model.contract.ContractDetail;
import com.case_study.repository.contract.IAttachFacilityRepository;
import com.case_study.repository.contract.IContractDetailRepository;
import com.case_study.repository.contract.IContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository contractRepository;

    @Autowired
    private IContractDetailRepository contractDetailRepository;

    @Autowired
    private IAttachFacilityRepository attachFacilityRepository;


    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public Optional<Contract> findById(int contractId) {
        return contractRepository.findById(contractId);
    }

    @Override
    public void update(int contractId, Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public void remove(int contractId) {
        contractRepository.deleteById(contractId);
    }

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public Page<Contract> totalMoney(Pageable pageable) {
        Page<Contract> contractList = this.findAll(pageable);
        List<AttachFacility> attachFacilityList = attachFacilityRepository.findAll();
        List<ContractDetail> contractDetailList = contractDetailRepository.findAll();
        for (Contract c: contractList) {
            double totalDetail = 0;
            double costFacility = 0;

            for (ContractDetail item : contractDetailList) {
                if (item.getContract().getContractId() == c.getContractId()) {
                    for (AttachFacility attach : attachFacilityList) {
                        if (attach.getAttachFacilityId() == item.getAttachFacility().getAttachFacilityId()) {
                            costFacility += item.getQuantity() * attach.getCost();
                        }
                    }
                }
            }
            totalDetail = costFacility + c.getFacility().getCost();
            c.setTotalMoney(totalDetail);
        }
        return contractList;
    }
}