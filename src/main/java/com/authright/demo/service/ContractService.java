package com.authright.demo.service;


import com.authright.demo.model.Contract;
import com.authright.demo.model.User;

import java.util.List;

public interface ContractService {
    Contract getContractByCompanyName(String companyName);
    List<Contract> getContractListByUser(User user);
}
