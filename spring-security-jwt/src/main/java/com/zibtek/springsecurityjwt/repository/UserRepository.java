package com.zibtek.springsecurityjwt.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.zibtek.springsecurityjwt.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUserName(String username);

	
}
