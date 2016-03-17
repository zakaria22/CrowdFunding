package com.univ.angers.dao;

import java.util.List;

import com.univ.angers.entities.*;



public interface ICrowdfundingDAO {

	public Long ajouterCategorie(Categorie c);
	public List<Categorie> listCategories();
	public Categorie getCategorie(Long idCat);
	public void supprimerCategrorie(Long idcat);
	public void modifierCategorie(Categorie c);
	
	public Long ajouterProjet(Projet p, Long idCat, Long idUser);
	public List<Projet> listprojets();
	public List<Projet> projetsParMotCle(String mc);
	public List<Projet> projetsParCategorie(Long idCat);
	public List<Projet> projet_A_finance();
	public List<Projet> listprojetsFinance();
	public Projet getProjet(Long idP);
	public void supprimerProjet(Long idP);
	public void modifierProjet(Projet p);
	
	public void ajouterUser(User u);
	public void attribuerRole(Role r,Long userID);
	
}
