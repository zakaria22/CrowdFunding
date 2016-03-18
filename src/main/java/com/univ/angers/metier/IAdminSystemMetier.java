package com.univ.angers.metier;

import com.univ.angers.entities.Categorie;
import com.univ.angers.entities.Role;
import com.univ.angers.entities.User;

public interface IAdminSystemMetier extends IAdminProjetMetier{

	public Long ajouterCategorie(Categorie c);
	public void supprimerCategrorie(Long idcat);
	public void modifierCategorie(Categorie c);
	public void ajouterUserAdmin(User u);
	public void attribuerRole(Role r,Long userID);

}
