package com.case_study.controller.contract;

import com.case_study.model.contract.ContractDetail;
import com.case_study.service.contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contractDetailRestFul")
public class ContractDetailController {
    @Autowired
    private IContractDetailService contractDetailService ;

    @GetMapping("/list/{id}")
    public ResponseEntity<List<ContractDetail>> getAllContractDetail(@PathVariable Integer id ){
        List<ContractDetail> contractDetails = this.contractDetailService.findAllByContract_contractId(id);
        if (contractDetails.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contractDetails , HttpStatus.OK);
    }

}
