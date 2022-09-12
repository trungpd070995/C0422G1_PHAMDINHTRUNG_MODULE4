package com.case_study.controller.contract;

import com.case_study.model.contract.Contract;
import com.case_study.service.contract.IAttachFacilityService;
import com.case_study.service.contract.IContractDetailService;
import com.case_study.service.contract.IContractService;
import com.case_study.service.customer.ICustomerService;
import com.case_study.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService contractService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IFacilityService facilityService;

    @Autowired
    private IContractDetailService contractDetailService;

    @Autowired
    private IAttachFacilityService attachFacilityService;

    @GetMapping("")
    public String index(Model model,@PageableDefault(value = 3) Pageable pageable) {
        Page<Contract> contractList = contractService.totalMoney(pageable);
        model.addAttribute("contractList", contractList);
        model.addAttribute("customerList", customerService.findAll());
        model.addAttribute("facilityList", facilityService.findAll());
        model.addAttribute("contractDetailList", attachFacilityService.findAllAttachFacility());
        return "contract/list";
    }


}