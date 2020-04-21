package com.example.service;

import java.util.List;

import com.example.bean.Articles;

public interface ArticlesService {
	Articles save(Articles articles);

	List<Articles> getAllArticles();

	

}
