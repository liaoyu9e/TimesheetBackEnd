package com.authright.demo.service.implement;

import com.authright.demo.model.WeekTime;
import com.authright.demo.repository.ContractRepository;
import com.authright.demo.repository.WeekTimeRepository;
import com.authright.demo.service.WeekTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeekTimeServiceImp implements WeekTimeService {

    @Autowired
    private WeekTimeRepository weekTimeRepository;

    @Autowired
    private ContractRepository contractRepository;

    @Override
    public WeekTime updateWeektime(WeekTime weekTime) {
        weekTime.setWeekId(1L);
        weekTime.setContract(contractRepository.getContractByCompanyName("Authright"));
        weekTimeRepository.save(weekTime);
        return weekTime;
    }
}
