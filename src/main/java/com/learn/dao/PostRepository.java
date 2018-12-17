package com.learn.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.learn.entities.Post;

@CrossOrigin("*")
public interface PostRepository extends JpaRepository<Post, Long>{

}
