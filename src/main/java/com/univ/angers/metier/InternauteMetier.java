package com.univ.angers.metier;

import java.util.List;

import com.univ.angers.entities.Categorie;
import com.univ.angers.entities.Projet;
import com.univ.angers.entities.User;

public interface InternauteMetier {

	public List<Projet> listprojets();
	public List<Projet> projetsParMotCle(String mc);
	public List<Projet> projetsParCategorie(Long idCat);
	public List<Projet> projet_A_finance();
	public List<Projet> listprojetsFinance();
	public Projet getProjet(Long idP);
	public List<Categorie> listCategories();
	public Categorie getCategorie(Long idCat);
	public void register(User u);
	

}
