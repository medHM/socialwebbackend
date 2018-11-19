package com.learn.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learn.dao.LivreRepository;
import com.learn.entities.Livre;


@RestController
 	
public class LivreRestService {
	@Autowired
	private LivreRepository livreRepository; 
	@RequestMapping(value="/livres",method=RequestMethod.GET)
	public List<Livre> getLivre(){
		return livreRepository.findAll();
	}
	@RequestMapping(value="/livres/{id}",method=RequestMethod.GET)
	public Optional<Livre> getLivre(@PathVariable Long id) {
		return livreRepository.findById(id);
	}
	@RequestMapping(value="/livres",method=RequestMethod.POST)
	public Livre saveLivre(@RequestBody Livre at) {
		return livreRepository.save(at);
	}	
	@RequestMapping(value="/livres/{id}",method=RequestMethod.DELETE)
	public boolean supprimerLivre(@PathVariable Long id) {
		livreRepository.deleteById(id);
		return true;
	}
	@RequestMapping(value="/livres/{id}",method=RequestMethod.PUT)
	public Livre saveLivre(@PathVariable Long id,@RequestBody Livre at) {
		at.setId(id);
		return livreRepository.save(at);
	}
}
