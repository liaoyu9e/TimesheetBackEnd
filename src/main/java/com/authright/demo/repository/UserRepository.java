package com.authright.demo.repository;

import com.authright.demo.model.User;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
