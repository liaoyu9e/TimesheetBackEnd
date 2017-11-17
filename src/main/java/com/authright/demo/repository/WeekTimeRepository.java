package com.authright.demo.repository;

import com.authright.demo.model.WeekTime;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface WeekTimeRepository extends CrudRepository<WeekTime, Long>{
}
