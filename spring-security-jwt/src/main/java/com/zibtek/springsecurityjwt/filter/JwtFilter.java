package com.zibtek.springsecurityjwt.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.zibtek.springsecurityjwt.service.CustomUserDetailService;
import com.zibtek.springsecurityjwt.until.JwtUtil;

@Component
public class JwtFilter extends OncePerRequestFilter {

	@Autowired
	private JwtUtil JwtUtil;
	
	@Autowired
	private CustomUserDetailService customUserDetailService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		System.out.println("vaild token");
		
		String authorizationHeader = request.getHeader("Authorization");
		String token = null;
		String userName = null;
		
		
		if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
			token=authorizationHeader.substring(7);
			userName=JwtUtil.extractUsername(token);	
		}
		
		if(userName != null && SecurityContextHolder.getContext().getAuthentication() == null ) {
		
			System.out.println("vaild token");
			
			UserDetails userDetails = customUserDetailService.loadUserByUsername(userName);
			
			if(JwtUtil.validateToken(token, userDetails)) {
				System.out.println("vaild token");
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
			
				usernamePasswordAuthenticationToken
					.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				
				
			}
			
		}
		
		filterChain.doFilter(request, response);
		
	}
}
