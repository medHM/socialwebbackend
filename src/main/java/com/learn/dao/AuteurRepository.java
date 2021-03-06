package com.learn.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.learn.entities.Auteur;

@CrossOrigin("*")
public interface AuteurRepository extends JpaRepository<Auteur, Long>{

}
