package com.univ.angers.metier;

import com.univ.angers.entities.Categorie;

public interface IAdminSystemMetier extends IAdminProjetMetier{
	public Long ajouterCategorie(Categorie c);
	public void supprimerCategrorie(Long idcat);
	public void modifierCategorie(Categorie c);
}
