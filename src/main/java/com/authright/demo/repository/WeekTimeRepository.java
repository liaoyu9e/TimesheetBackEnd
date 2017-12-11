package com.authright.demo.repository;

import com.authright.demo.model.Contract;
import com.authright.demo.model.WeekTime;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface WeekTimeRepository extends CrudRepository<WeekTime, Long>{
    List<WeekTime> getWeekTimesByContract(Contract contract);
}
