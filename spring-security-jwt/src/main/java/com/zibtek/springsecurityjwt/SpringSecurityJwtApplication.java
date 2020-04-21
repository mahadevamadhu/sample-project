package com.zibtek.springsecurityjwt;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.zibtek.springsecurityjwt.entity.User;
import com.zibtek.springsecurityjwt.repository.UserRepository;

@SpringBootApplication
public class SpringSecurityJwtApplication {

	
	@Autowired
	private UserRepository userrepository;
	
	@PostConstruct
	public void initUser() {
		
		List<User> users =  Stream.of(
				new User(101,"madhu","password","madhu@gmail.com")
				).collect(Collectors.toList());
		
		userrepository.saveAll(users);
		
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtApplication.class, args);
	}

}
