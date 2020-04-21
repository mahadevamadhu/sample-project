package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bean.Articles;
import com.example.dao.ArticlesDao;
@Service
public class ArticlesServiceImpl implements ArticlesService{
	@Autowired(required = true)
	private ArticlesDao dao;
	@Override
	public Articles save(Articles articles) {
		// TODO Auto-generated method stub
		return dao.save(articles);
	}
	
	
	
	@Override
	public List<Articles> getAllArticles() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
