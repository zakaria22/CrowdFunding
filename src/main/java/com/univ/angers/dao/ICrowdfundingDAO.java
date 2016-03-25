package com.univ.angers.dao;

import java.util.List;

import com.univ.angers.entities.Categorie;
import com.univ.angers.entities.Commentaire;
import com.univ.angers.entities.Contribution;
import com.univ.angers.entities.Projet;
import com.univ.angers.entities.User;

public interface ICrowdFundingDAO {
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
	public Contribution contribuerProjet(Long idProjet,Long idUser,Contribution c);
	
	public Long ajouterCommentaire(Commentaire c, Long idP, Long idUser);
	public List<Commentaire> listcommentaires(Long idP);

	
	//public void ajouterUserAdmin(User u);
	public void register(User u);
	public List<User> listusers();
	public User getUser(Long idUSer);
	
}
