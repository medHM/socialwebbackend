package com.learn.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Livre implements Serializable{
	@Id @GeneratedValue
	private Long id;
	private String nom;
	@Column(length=512)
	private String Description;
	@ManyToOne
	@JoinColumn(name="CODE_AUTEUR")
	private Auteur auteur;
	public Livre() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Livre(String nom, String description) {
		super();
		this.nom = nom;
		Description = description;
	}
	
	public Livre(String nom, String description, Auteur auteur) {
		super();
		this.nom = nom;
		Description = description;
		this.auteur = auteur;
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
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Auteur getAuteur() {
		return auteur;
	}
	public void setAuteur(Auteur auteur) {
		this.auteur = auteur;
	}
	
}
