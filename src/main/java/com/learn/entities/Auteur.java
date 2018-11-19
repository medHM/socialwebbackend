package com.learn.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Auteur implements Serializable{
	@Id @GeneratedValue
	private Long id;
	private String nom;
	private String prenom;
	@OneToMany(mappedBy="auteur", fetch=FetchType.LAZY)
	private Collection<Livre>livres;
	public Auteur() {
		super();
		// TODO Auto-generated constructor stub
	}
		
	public Auteur(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}	
}
