package com.learn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.entities.Livre;

public interface LivreRepository extends JpaRepository<Livre, Long>{

}
