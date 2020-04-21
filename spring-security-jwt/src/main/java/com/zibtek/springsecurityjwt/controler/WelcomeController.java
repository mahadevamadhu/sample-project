package com.zibtek.springsecurityjwt.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zibtek.springsecurityjwt.entity.AuthRequest;
import com.zibtek.springsecurityjwt.until.JwtUtil;

@RestController
public class WelcomeController {

	@Autowired 
	private JwtUtil  JwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	@GetMapping("/")
	public String welcome() {
		
		return "welcome to springboot";
	}
	
	@PostMapping("/auth")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception{
		
		try {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
		}
		catch (Exception e) {
			throw new Exception("invaild username or password");
		}
		
		return JwtUtil.generateToken(authRequest.getUserName());
		
	}
}
