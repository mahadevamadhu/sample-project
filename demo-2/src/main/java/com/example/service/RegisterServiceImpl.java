package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bean.Register;
import com.example.dao.RegisterDao;
@Service
public class RegisterServiceImpl implements RegisterService {

	
	@Autowired(required = true)
	private RegisterDao dao;

	@Override
	public Register save(Register register) {
		return dao.save(register);
	}

	@Override
	public boolean findEmployee(String userName, String password) {
		// TODO Auto-generated method stub
		int res = dao.getEmployee(userName, password);
		if (res == 0) {
			return false;
		}else {
			
		return true;
		}
		}
 
}
