package com.authright.demo.repository;

import com.authright.demo.model.Contract;
import com.authright.demo.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContractRepository extends CrudRepository<Contract, Long> {
    Contract getContractByCompanyName(String companyName);
    List<Contract> getContractsByUser(User user);
}
