package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.models.User;
import com.example.demo.repo.UserRepository;

@SpringBootApplication
public class SpringBootSecurityApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setEmail("John@gmail.com");
		user.setUsername("john");
		user.setPassword(this.bCryptPasswordEncoder.encode("shagun"));
		user.setRole("ROLE_NORMAL");

		this.userRepository.save(user);

		User user1 = new User();
		user1.setEmail("Roshini@gmail.com");
		user1.setUsername("roshini");
		user1.setPassword(this.bCryptPasswordEncoder.encode("shagun"));
		user1.setRole("ROLE_ADMIN");

		this.userRepository.save(user1);
	}

}
