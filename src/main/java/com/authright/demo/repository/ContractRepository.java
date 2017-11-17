package com.authright.demo.repository;

import com.authright.demo.model.Contract;
import org.springframework.data.repository.CrudRepository;

public interface ContractRepository extends CrudRepository<Contract, Long> {
    Contract getContractByCompanyName(String companyName);
}
