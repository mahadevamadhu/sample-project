package com.example.service;

import com.example.bean.Register;

public interface RegisterService {
	Register save(Register register);

	boolean findEmployee(String userName, String password);
}
