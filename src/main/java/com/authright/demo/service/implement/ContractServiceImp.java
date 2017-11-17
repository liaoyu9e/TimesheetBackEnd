package com.authright.demo.service.implement;

import com.authright.demo.model.Contract;
import com.authright.demo.repository.ContractRepository;
import com.authright.demo.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractServiceImp implements ContractService {

    @Autowired
    private ContractRepository contractRepository;


    @Override
    public Contract getContractByCompanyName(String companyName) {
        return contractRepository.getContractByCompanyName(companyName);
    }
}
