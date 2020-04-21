package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.bean.Register;
@Repository
public interface RegisterDao extends JpaRepository<Register, Integer>{

	@Query("select count(*) from Register where userName=:userName and password=:password")
	int getEmployee(@Param(value = "userName") String userName,@Param(value = "password") String password);
	
} 
