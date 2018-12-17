package com.learn.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.learn.entities.Commentaire;

@CrossOrigin("*")
public interface CommentaireRepository extends JpaRepository<Commentaire, Long>{

}
