package com.learn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.learn.dao.AuteurRepository;
import com.learn.dao.LivreRepository;
import com.learn.entities.Auteur;
import com.learn.entities.Livre;

@SpringBootApplication
public class BibApplication implements CommandLineRunner{
	@Autowired
	private AuteurRepository auteurRepository;
	@Autowired
	private LivreRepository livreRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BibApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Auteur a1 = auteurRepository.save(new Auteur("Patrick ", "Süskind"));
		Auteur a2 = auteurRepository.save(new Auteur("Paulo", "Coelho"));
		Auteur a3 = auteurRepository.save(new Auteur("Haouari", "Amine"));
		 
		auteurRepository.findAll().forEach(c->{
			System.out.println(c.getNom() + c.getPrenom());
		});
		Livre l1 =livreRepository.save(new Livre("Le parfun", "L'histoire abominable et drolatique de Jean-Baptiste Grenouille a déjà fait rire et frémir, en quelques mois, des centaines de milliers de lecteurs allemands et italiens. La voilà, en somme, réimportée en France, puisque c'est ici qu'elle se passe, à Paris et en Provence, en plein XVIII siècle",a1));
		Livre l2 =livreRepository.save(new Livre("L'alchimiste", "Santiago, un jeune berger andalou, part à la recherche d'un trésor enfoui au pied des Pyramides.",a3));
		
		livreRepository.findAll().forEach(l->{
			System.out.println(l.getNom()+l.getDescription()+l.getAuteur().getNom());
		});
	}
}
