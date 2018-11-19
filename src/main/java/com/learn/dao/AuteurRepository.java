package com.learn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.entities.Auteur;

public interface AuteurRepository extends JpaRepository<Auteur, Long>{

}
