package com.authright.demo;

import com.authright.demo.entity.Role;
import com.authright.demo.entity.User;
import com.authright.demo.entity.UserRole;
import com.authright.demo.repository.RoleRepository;
import com.authright.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HRMBackendApplication implements CommandLineRunner{

	@Autowired
	private UserService userService;

	@Autowired
	private RoleRepository roleRepository;

	public static void main(String[] args) {

		SpringApplication.run(HRMBackendApplication.class, args);
	}

	//initial roles and users for test
	@Override
	public void run(String... strings) {
		User user = new User();
		Role role = new Role();

		if (roleRepository.findOne(1) == null){
			role.setRoleId(1);
			role.setName("ROLE_USER");
			roleRepository.save(role);
		}

		if (roleRepository.findOne(2) == null){
			role.setRoleId(2);
			role.setName("ROLE_MANAGER");
			roleRepository.save(role);
		}

		role.setRoleId(3);
		role.setName("ROLE_ADMIN");
		if (roleRepository.findOne(3) == null){
			roleRepository.save(role);
		}
		user.setUserId(1L);
		user.setUsername("admin");
		user.setPassword("admin");
		user.setFirstName("Admin");
		user.setLastName("Admin");
		user.setEmail("Admin@test.com");
		user.getUserRoles().add(new UserRole(user, role));
		userService.createUser(user);

		role.setRoleId(2);
		user.setUserId(2L);
		user.setUsername("liaoyu");
		user.setPassword("321");
		user.setFirstName("Yu");
		user.setLastName("Liao");
		user.setEmail("liaoyu9e@gmail.com");
		user.getUserRoles().clear();
		user.getUserRoles().add(new UserRole(user, role));
		userService.createUser(user);

		user.setUserId(3L);
		user.setUsername("user1");
		user.setPassword("pass1");
		user.setFirstName("Chen");
		user.setLastName("Hua");
		user.setEmail("chen.hua@authright.com");
		user.getUserRoles().clear();
		userService.createUser(user);
	}
}
