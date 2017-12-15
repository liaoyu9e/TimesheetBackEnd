package com.authright.demo.service.implement;

import com.authright.demo.entity.Role;
import com.authright.demo.entity.User;
import com.authright.demo.entity.UserRole;
import com.authright.demo.repository.UserRepository;
import com.authright.demo.service.UserService;
import com.authright.demo.utility.SecurityUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


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
            Role roleOfUser = new Role();
            roleOfUser.setRoleId(1);
//            roleOfUser.setName("ROLE_USER");
            UserRole userRole = new UserRole(user, roleOfUser);
            user.getUserRoles().add(userRole);
            roleOfUser.getUserRoles().add(userRole);

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
