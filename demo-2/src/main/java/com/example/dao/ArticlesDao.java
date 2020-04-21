package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bean.Articles;
@Repository
public interface ArticlesDao extends JpaRepository<Articles, Integer>{
}
