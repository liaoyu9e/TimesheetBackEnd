package com.authright.demo.service;


import com.authright.demo.entity.Contract;
import com.authright.demo.entity.User;

import java.util.List;

public interface ContractService {
    Contract getContractByCompanyName(String companyName);
    List<Contract> getContractListByUser(User user);
}
