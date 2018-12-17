package com.learn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.learn.dao.AuteurRepository;
import com.learn.dao.CommentaireRepository;
import com.learn.dao.LivreRepository;
import com.learn.entities.Auteur;
import com.learn.entities.Livre;
import com.learn.entities.Post;
import com.learn.entities.Commentaire;

@SpringBootApplication
public class BibApplication implements CommandLineRunner{
	@Autowired
	private AuteurRepository auteurRepository;
	@Autowired
	private LivreRepository livreRepository;
	@Autowired
	private CommentaireRepository commentaireRepository;
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	
	public static void main(String[] args) {
		SpringApplication.run(BibApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Post.class, Commentaire.class, Livre.class, Auteur.class);
		Auteur a1 = auteurRepository.save(new Auteur("Patrick ", "Süskind","Beck Joe, née au Canada. J'aime boucoup le cinéma."));
		Auteur a2 = auteurRepository.save(new Auteur("Paulo", "Coelho","deds"));
		Auteur a3 = auteurRepository.save(new Auteur("Haouari", "Amine","dfdf"));
		 
		auteurRepository.findAll().forEach(c->{
			System.out.println(c.getNom() + c.getPrenom());
		});
		Livre l1 =livreRepository.save(new Livre("Le parfum", "L'histoire abominable et drolatique de Jean-Baptiste Grenouille a déjà fait rire et frémir, en quelques mois, des centaines de milliers de lecteurs allemands et italiens. La voilà, en somme, réimportée en France, puisque c'est ici qu'elle se passe, à Paris et en Provence, en plein XVIII siècle",a1));
		Livre l2 =livreRepository.save(new Livre("L'alchimiste", "Santiago, un jeune berger andalou, part à la recherche d'un trésor enfoui au pied des Pyramides.",a3));
		
		livreRepository.findAll().forEach(l->{
			System.out.println(l.getNom()+l.getDescription()+l.getAuteur().getNom());
		});
	}
}
