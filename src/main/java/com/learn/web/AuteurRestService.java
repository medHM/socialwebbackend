package com.learn.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.learn.entities.Auteur;
import com.learn.dao.AuteurRepository;


@RestController
@CrossOrigin("*")
public class AuteurRestService {
	@Autowired
	private AuteurRepository auteurRepository; 
	@RequestMapping(value="/auteurs",method=RequestMethod.GET)
	public List<Auteur> getAuteur(){
		return auteurRepository.findAll();
	}
	@RequestMapping(value="/auteurs/{id}",method=RequestMethod.GET)
	public Optional<Auteur> getAuteur(@PathVariable Long id) {
		return auteurRepository.findById(id);
	}
	@RequestMapping(value="/auteurs",method=RequestMethod.POST)
	public Auteur saveAuteur(@RequestBody Auteur at) {
		return auteurRepository.save(at);
	}	
	@RequestMapping(value="/auteurs/{id}",method=RequestMethod.DELETE)
	public boolean supprimerAuteur(@PathVariable Long id) {
		auteurRepository.deleteById(id);
		return true;
	}
	@RequestMapping(value="/auteurs/{id}",method=RequestMethod.PUT)
	public Auteur saveAuteur(@PathVariable Long id,@RequestBody Auteur at) {
		at.setId(id);
		return auteurRepository.save(at);
	}
}
