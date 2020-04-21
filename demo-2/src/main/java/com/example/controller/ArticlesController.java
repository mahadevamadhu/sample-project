package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.Articles;
import com.example.bean.Register;
import com.example.service.ArticlesService;

@RestController
public class ArticlesController {
	@Autowired(required = true)
	private ArticlesService service;
	/* save user articles*/
	@PostMapping(value = "/articles")
	public Object saveEmployee(@RequestBody Articles articles) {
		String jsonString;
		try {
			service.save(articles);
			 jsonString="{\"response\":{\"statusCode\":\"201\",\"body\":{\"messgae\":\"new article created\"}}}";

		} catch (Exception e) {
			 jsonString="{\"response\":{\"statusCode\":\"500\",\"body\":{\"messgae\":\"articals not found\"}}}";

		}
		
		return new ResponseEntity<>(jsonString, HttpStatus.OK);

	}
	/*get all articels*/
	@GetMapping(value = "/articles")
	public List<Articles> name() {
		return service.getAllArticles ();

	}
	
}
