package com.example.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.Register;
import com.example.service.RegisterService;

@RestController
public class RegisterController {
	@Autowired(required = true)
	private RegisterService service;
	/*register user service*/
	@PostMapping(value = "/RegisterUser")
	public Object saveEmployee(@RequestBody Register register) {
		 String jsonString;
try {
	service.save(register);
	  jsonString="{\"response\":{\"statusCode\":\"201\",\"body\":{\"messgae\":\"new user created\"}}}";

} catch (Exception e) {
	  jsonString="{\"response\":{\"statusCode\":\"500\",\"body\":{\"messgae\":\"User save or updated failed.\"}}}";

}
		
return new ResponseEntity<>(jsonString, HttpStatus.OK);

	}
	/* login user service */
	@PostMapping(value = "/validate")
	public Object loginValidation(@RequestBody Register register) {
		String userName = register.getUsername();
		String password = register.getPassword();
		String jsonString;
		try {
			 service.findEmployee(userName, password);
			  jsonString="{\"response\":{\"statusCode\":\"201\",\"body\":{\"messgae\":\"new user created\"}}}";

		} catch (Exception e) {
			  jsonString="{\"response\":{\"statusCode\":\"500\",\"body\":{\"messgae\":\"failed to login\"}}}";

		}
			
		 return new ResponseEntity<>(jsonString, HttpStatus.OK);
	}
	
	
	
	
	 
}
