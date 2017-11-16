package com.authright.demo.service.implement;

import com.authright.demo.model.Role;
import com.authright.demo.model.User;
import com.authright.demo.model.UserRole;
import com.authright.demo.repository.UserRepository;
import com.authright.demo.service.UserService;
import com.authright.demo.utility.SecurityUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Service
public class UserServiceImp implements UserService {
    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        User localUser = userRepository.findByUsername(user.getUsername());
        if (localUser != null){
            LOG.info("User with username {} already exist. Please select another one!", user.getUsername());
        }else{
            Set<UserRole> userRoles = new HashSet<>();
            Role localRole = new Role();
            localRole.setRoleId(2);
            userRoles.add(new UserRole(user, localRole));
            user.getUserRoles().addAll(userRoles);

            Date today = new Date();
            user.setJoinDate(today);

            String encryptPassword = SecurityUtility.passwordEncoder().encode(user.getPassword());
            user.setPassword(encryptPassword);
            localUser = userRepository.save(user);
        }
        return localUser;
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

}
