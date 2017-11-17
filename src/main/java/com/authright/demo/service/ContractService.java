package com.authright.demo.service;


import com.authright.demo.model.Contract;

public interface ContractService {
    Contract getContractByCompanyName(String companyName);
}
