package com.univ.angers;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.univ.angers.entities.Categorie;
import com.univ.angers.entities.Contribution;
import com.univ.angers.entities.Projet;
import com.univ.angers.entities.User;
import com.univ.angers.metier.ContributeurMetierImpl;
import com.univ.angers.metier.IAdminProjetMetier;
import com.univ.angers.metier.IAdminSystemMetier;
import com.univ.angers.metier.IContributeurMetier;
import com.univ.angers.metier.InternauteMetier;

public class TestMetier {


	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void AdminSystem() {
		try {
			ClassPathXmlApplicationContext context= 
					new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
			
			IAdminSystemMetier adminSystem = 
					(IAdminSystemMetier) context.getBean("adminSystemMetier");
			
			//récuperer la liste des catégories
			List<Categorie> cts1 = adminSystem.listCategories();
			
			//ajouter des categories
			adminSystem.ajouterCategorie(new Categorie("Immobi", "blablablabla", null, "test.jpeg"));
			adminSystem.ajouterCategorie(new Categorie("Startus", "blablablablabla bla bala", null, "test2.jpeg"));

			//récuperer a nouveau la liste des categories
			List<Categorie> cts2 = adminSystem.listCategories();
			
			//tester si les 2 catégories ont bien été crée
			assertTrue(cts1.size()+2==cts2.size());
			
		} catch (Exception e) {
			// TODO: handle exception
			assertTrue(e.getMessage(),false);

		}
	}

	

	@Test
	public void internaute() {
		try {
			ClassPathXmlApplicationContext context= 
					new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
			
			InternauteMetier internaute = 
					(InternauteMetier) context.getBean("InternauteMetier");
			
			
			internaute.register(new User("zakaria", "passwordZak", true, "adress1 angers", "email", "0641589512"));
			internaute.register(new User("zakaria", "passwordZdssak", true, "adress1 angers", "email", "0641589512"));

			//tester si les 2 catégories ont bien été crée
			assertTrue(true);
			
		} catch (Exception e) {
			// TODO: handle exception
			assertTrue(e.getMessage(),false);
		}
	}
	
	@Test
	public void ajoutProjet() {
		try {
			ClassPathXmlApplicationContext context= 
					new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
			
			IAdminProjetMetier adminProjet = 
					(IAdminProjetMetier) context.getBean("adminProjetMetier");
			
			//récuperer la liste des catégories
			List<Projet> pro1 = adminProjet.listprojets();
			
			//ajouter des categories
			adminProjet.ajouterProjet(new Projet("projet1", "blabla balakd é", 220000,2520 , false, null, "lol.jpeg"), (long) 1, (long) 1);
			adminProjet.ajouterProjet(new Projet("projet2", "blabla balakd é", 300000,30000 , false, null, "lol1.jpeg"), (long) 1, (long) 1);

			//récuperer a nouveau la liste des categories
			List<Projet> pro2 = adminProjet.listprojets();
			
			//tester si les 2 catégories ont bien été crée
			assertTrue(pro1.size()+2==pro2.size());
			
		} catch (Exception e) {
			// TODO: handle exception
			assertTrue(e.getMessage(),false);

		}
	}
	
	@Test
	public void TestContribution() {
		try {
			ClassPathXmlApplicationContext context= 
					new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
			
			IContributeurMetier contribProjet = 
					(IContributeurMetier) context.getBean("ContributeurMetier");
			
			
			contribProjet.contribuerProjet((long) 1, (long) 2, new Contribution(265));
			
			assertTrue(true);
			
		} catch (Exception e) {
			// TODO: handle exception
			assertTrue(e.getMessage(),false);

		}
	}
}
