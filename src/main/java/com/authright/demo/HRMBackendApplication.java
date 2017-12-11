package com.authright.demo;

import com.authright.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HRMBackendApplication implements CommandLineRunner{

	@Autowired
	private UserService userService;

	public static void main(String[] args) {

		SpringApplication.run(HRMBackendApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

	}
}
